using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using DeliveryLibrary;

namespace DeliveryManager
{
    public partial class frmDetalhePedido : Form
    {
        public frmDetalhePedido(Pedido pedido)
        {
            InitializeComponent();
            txtDataHora.Text = pedido.Data.ToString("dd/MM/yyyy HH:mm:ss");
            txtEspera.Text = pedido.Espera + " min";
            txtCliente.Text = pedido.NomeCliente;
            txtTelefone.Text = pedido.Telefone.ToString();
            txtEndereco.Text = pedido.Endereco;
            txtBairro.Text = pedido.Bairro;

            lstItensPedido.Items.Clear();
            lstItensPedido.Groups.Clear();
            lstItensPedido.Columns.Clear();
            lstItensPedido.View = View.Details;

            lstItensPedido.Columns.Add("Item", 150);
            lstItensPedido.Columns.Add("Vlr Unit", 70);
            lstItensPedido.Columns.Add("Qtde", 40);
            lstItensPedido.Columns.Add("Subtotal", 70);

            foreach (ItemPedido item in pedido.ItensPedido)
            {
                ListViewItem i = new ListViewItem();
                i.Text = item.ToString();
                i.SubItems.Add(item.ValorUnitario.ToDinheiro());
                i.SubItems.Add(item.Quantidade.ToString());
                i.SubItems.Add((item.ValorUnitario * item.Quantidade).ToDinheiro());
                lstItensPedido.Items.Add(i);
            }

            txtValorTotal.Text = pedido.ValorTotal.ToDinheiro();

            switch(pedido.FormaPagto)
            {
                case 1:
                    txtFormaPagto.Text = "Dinheiro";
                    break;

                case 2:
                    txtFormaPagto.Text = "Master Card Crédito/Débito";
                    break;

                case 3:
                    txtFormaPagto.Text = "Visa Crédito/Débito";
                    break;
            }

            lblTrocoPara.Visible = txtTrocoPara.Visible = lblValorTroco.Visible = txtValorTroco.Visible = (pedido.FormaPagto == 1);
            txtTrocoPara.Text = string.Format("R$ {0:#,##0.00}", pedido.TrocoPara);
            txtValorTroco.Text = string.Format("R$ {0:#,##0.00}", (pedido.TrocoPara - pedido.ValorTotal));
        }
    }
}
