using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DeliveryManager
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
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

            /* Cria as colunas */
            lstPedidos.Columns.Add("Data", 80);
            lstPedidos.Columns.Add("Hora", 80);
            lstPedidos.Columns.Add("Espera", 80);
            lstPedidos.Columns.Add("Cliente", 150);
            lstPedidos.Columns.Add("Bairro", 150);
            lstPedidos.Columns.Add("Valor Total", 150);

            /* Cria os grupos */
            lstPedidos.Groups.Add("NovosPedidos", "Novos Pedidos");
            lstPedidos.Groups.Add("EmProcessamento", "Em Processamento");
            lstPedidos.Groups.Add("Finalizados", "Finalizados");
        }
    }
}
