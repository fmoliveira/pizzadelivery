using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http.Routing;
using System.Web.Http.SelfHost;

namespace DeliveryService
{
    class Program
    {
        static void Main(string[] args)
        {
            string baseAddress = "http://localhost:12345/";
            HttpSelfHostConfiguration config = new HttpSelfHostConfiguration(baseAddress);
            config.Routes.Add("PizzaService", new HttpRoute("PizzaService/{controller}"));

            HttpSelfHostServer server = new HttpSelfHostServer(config);
            server.OpenAsync().Wait();
            Console.WriteLine("Serviço do Pizza Delivery rodando... :)");

            Console.ReadKey();

            server.CloseAsync().Wait();
        }
    }
}
