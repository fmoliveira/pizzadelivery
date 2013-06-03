using DeliveryLibrary;
using HttpUtils;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;
using System.Windows.Forms;

namespace DeliveryManager
{
    public partial class frmMain : Form
    {
        private Timer mTimer = null;

        public frmMain()
        {
            InitializeComponent();
            mTimer = new Timer();
            mTimer.Interval = 3000;
            mTimer.Tick += mTimer_Tick;
            mTimer.Start();
        }

        private void mTimer_Tick(object sender, EventArgs e)
        {
            ListarPedidos();
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            prepararListaPedidos();
        }

        private void prepararListaPedidos()
        {
            lstPedidos.Items.Clear();
            lstPedidos.Groups.Clear();
            lstPedidos.Columns.Clear();

            /* Ajustes gerais */
            lstPedidos.View = View.Details;
            lstPedidos.ListViewItemSorter = new PedidosComparer();

            /* Cria as colunas */
            lstPedidos.Columns.Add("ID", 0);
            lstPedidos.Columns.Add("Data", 80);
            lstPedidos.Columns.Add("Hora", 80);
            lstPedidos.Columns.Add("Espera", 80);
            lstPedidos.Columns.Add("Cliente", 150);
            lstPedidos.Columns.Add("Bairro", 150);
            lstPedidos.Columns.Add("Valor Total", 150);
        }

        private int mUltimoPedido = 0;

        private void ListarPedidos()
        {
            string endPoint = string.Format("http://www.fmoliveira.com.br/PizzaService/api/pedido/{0}", mUltimoPedido);
            var client = new RestClient(endPoint);
            string json = null;  

            try
            {
                json = client.MakeRequest();
            }
            catch (Exception)
            {
                return;
            }

            JavaScriptSerializer js = new JavaScriptSerializer();
            List<Pedido> lista = js.Deserialize<List<Pedido>>(json);
            ListViewItem item;
            TimeSpan ts;
            int unix, diff;

            for (int i = 0; i < lstPedidos.Items.Count; i++)
            {
                if (int.TryParse(lstPedidos.Items[i].SubItems[0].Text, out unix))
                {
                    ts = DateTime.Now - new DateTime(1970, 1, 1, 0, 0, 0);
                    diff = ((int)ts.TotalSeconds) - unix;
                    lstPedidos.Items[i].BackColor = (diff > 0 && diff < 30) ? Color.Khaki : Color.Transparent;
                }
            }

            foreach (Pedido p in lista)
            {
                ts = p.Data - new DateTime(1970, 1, 1, 0, 0, 0);
                unix = (int)ts.TotalSeconds;

                item = new ListViewItem(unix.ToString());
                item.BackColor = Color.Khaki;
                item.SubItems.Add(p.Data.ToString("dd/MM/yyyy"));
                item.SubItems.Add(p.Data.ToString("HH:mm:ss"));
                item.SubItems.Add(string.Format("{0} min", p.Espera));
                item.SubItems.Add(p.NomeCliente);
                item.SubItems.Add(p.Bairro);
                item.SubItems.Add(string.Format("R$ {0:#,##0.00}", p.ValorTotal));
                item.Tag = p;
                lstPedidos.Items.Add(item);

                if (unix > mUltimoPedido)
                {
                    mUltimoPedido = unix;
                }
            }
        }

        private void lstPedidos_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            if (lstPedidos.SelectedItems.Count == 1)
            {
                if (lstPedidos.SelectedItems[0].Tag is Pedido)
                {
                    Pedido p = (lstPedidos.SelectedItems[0].Tag as Pedido);
                    frmDetalhePedido detalhe = new frmDetalhePedido(p);
                    detalhe.ShowDialog();
                }
            }
        }
    }
}
