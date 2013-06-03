using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DeliveryLibrary
{
    public class ItemPedido
    {
        public int Id { get; set; }

        public int Tipo { get; set; }

        public int Tamanho { get; set; }

        public int Quantidade { get; set; }

        public double ValorUnitario { get; set; }

        public double SubTotal { get; set; }

        public override string ToString()
        {
            string s = string.Empty;

            if (Tipo == 0)
            {
                switch (Id)
                {
                    case 0:
                        s += "Calabresa";
                        break;

                    case 1:
                        s += "Coreana";
                        break;

                    case 2:
                        s += "Corn & Bacon";
                        break;

                    case 3:
                        s += "Country";
                        break;

                    case 4:
                        s += "Marguerita";
                        break;

                    case 5:
                        s += "Supreme";
                        break;

                    default:
                        s += "Pizza";
                        break;
                }

                switch (Tamanho)
                {
                    case 0:
                        s += " (Grande)";
                        break;

                    case 1:
                        s += " (Gigante)";
                        break;
                }
            }
            else if (Tipo == 1)
            {
                switch (Id)
                {
                    case 0:
                        s += "Pepsi";
                        break;

                    case 1:
                        s += "Pepsi Light";
                        break;

                    case 2:
                        s += "Guaraná";
                        break;

                    case 3:
                        s += "Guaraná Zero";
                        break;

                    case 4:
                        s += "H2O";
                        break;

                    case 5:
                        s += "Ice Tea";
                        break;

                    default:
                        s += "Bebida";
                        break;
                }
            }
            else
            {
                s += "Item";
            }

            return s;
        }
    }
}