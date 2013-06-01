using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DeliveryManager
{
    public static class Extensoes
    {
        public static string ToDinheiro(this double valor)
        {
            return string.Format("R$ {0:#,##0.00}", valor);
        }
    }
}
