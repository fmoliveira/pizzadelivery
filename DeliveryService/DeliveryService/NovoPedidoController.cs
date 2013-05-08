using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace DeliveryService
{
    public class NovoPedidoController : ApiController
    {
        [HttpPost]
        public HttpResponseMessage Post([FromBody]string json)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    //Contact contact = _contacts.AddContact(value);
                    //var response = Request.CreateResponse<contact>(HttpStatusCode.Created, contact);
                    //return response;
                    return Request.CreateResponse(HttpStatusCode.Created, "Pedido realizado com sucesso!");
                }
                else
                {
                    return Request.CreateResponse(HttpStatusCode.InternalServerError, "Modelo inválido!");
                }
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.InternalServerError, ex.Message);
            }
        }
    }
}
