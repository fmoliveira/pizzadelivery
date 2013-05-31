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
            txtEndereco.Text = pedido.Endereco;
            txtBairro.Text = pedido.Bairro;

            txtValorTotal.Text = string.Format("R$ {0:#,##0.00}", pedido.ValorTotal);

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
