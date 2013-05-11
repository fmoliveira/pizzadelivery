﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DeliveryLibrary
{
    public class Pedido
    {
        public int PedidoId { get; set; }

        public DateTime Data { get; set; }

        public int Espera { get; set; }

        public string NomeCliente { get; set; }

        public int Telefone { get; set; }

        public string Endereco { get; set; }

        public string Bairro { get; set; }

        public List<ItemPedido> ItensPedido { get; set; }
    }
}