using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DeliveryManager
{
    public class PedidosComparer : IComparer
    {
        public int Compare(object x, object y)
        {
            ListViewItem listX = (ListViewItem)x;
            ListViewItem listY = (ListViewItem)y;

            int xval = 0, yval = 0;
            int.TryParse(listX.SubItems[0].Text, out xval);
            int.TryParse(listY.SubItems[0].Text, out yval);

            return (yval - xval);
        }
    }
}
