using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DeliveryLibrary
{
    public class Pedido
    {
        public int Telefone { get; set; }

        public DateTime DataPedido { get; set; }

        public Endereco Endereco { get; set; }

        public List<ItemPedido> ItensPedido { get; set; }
    }
}