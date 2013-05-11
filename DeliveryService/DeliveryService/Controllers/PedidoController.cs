using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Script.Serialization;
using DeliveryLibrary;
using System.Data.SqlClient;
using System.Data;

namespace DeliveryService.Controllers
{
    public class PedidoController : ApiController
    {
        private string connstr = "Data Source=localhost; User Id=sa; Password=eugenia; Initial Catalog=PizzaDelivery;";

        // GET api/pedido
        public IEnumerable<Pedido> Get()
        {
            SqlConnection conn = new SqlConnection(connstr);
            SqlCommand cmd = null;
            SqlDataReader reader = null;

            List<Pedido> lista = new List<Pedido>();

            try
            {
                conn.Open();

                cmd = conn.CreateCommand();
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT PedidoId, Data, Espera, NomeCliente, Endereco, Bairro FROM Pedidos;";
                reader = cmd.ExecuteReader();

                if (reader.HasRows)
                {
                    if (reader.Read())
                    {
                        Pedido p = new Pedido();
                        p.PedidoId = (int)reader["PedidoId"];
                        p.Data = (DateTime)reader["Data"];
                        p.Espera = (int)reader["Espera"];
                        p.NomeCliente = reader["NomeCliente"].ToString();
                        p.Endereco = reader["Endereco"].ToString();
                        p.Bairro = reader["Bairro"].ToString();
                        lista.Add(p);
                    }
                }
            }
            catch { }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                }

                if (conn != null)
                {
                    conn.Close();
                }
            }

            return lista.ToArray();
        }

        // GET api/pedido/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/pedido
        public void Post([FromBody]string value)
        {
            // {"NomeCliente":"John Doe","Data":"2013-05-10 20:40:53","Telefone":"32540083","Endereco":"Rua Dr Sales de Oliveira 1661","Bairro":"Vila Industrial",ItensPedido:[{"Id":0,"Quantidade":1,"Tamanho":0,"Tipo":0},{"Id":0,"Quantidade":1,"Tamanho":0,"Tipo":1}]}

            JavaScriptSerializer json = new JavaScriptSerializer();
            Pedido pedido = json.Deserialize<Pedido>(value);

            SqlConnection conn = new SqlConnection(connstr);
            SqlTransaction tran = null;
            SqlCommand cmd = null;

            try
            {
                conn.Open();
                tran = conn.BeginTransaction();
                cmd = conn.CreateCommand();
                cmd.CommandType = CommandType.Text;
                cmd.Transaction = tran;

                cmd.CommandText = string.Format("INSERT INTO Pedidos (Data, NomeCliente, Endereco, Bairro) VALUES ('{0}', '{1}', '{2}', '{3}');", pedido.Data, pedido.NomeCliente, pedido.Endereco, pedido.Bairro);
                cmd.ExecuteNonQuery();

                object o;
                int id = 0;
                cmd.CommandText = "SELECT MAX(PedidoId) FROM Pedidos;";
                o = cmd.ExecuteScalar();

                if (o != null && o is int)
                {
                    id = (int)o;

                    for (int i = 0; i < pedido.ItensPedido.Count; i++)
                    {
                        cmd.CommandText = string.Format("INSERT INTO PedidosItens (PedidoId, Indice, Id, Tipo, Tamanho, Quantidade) VALUES ({0}, {1}, {2}, {3}, {4}, {5});", id, i + 1, pedido.ItensPedido[i].Id, pedido.ItensPedido[i].Tipo, pedido.ItensPedido[i].Tamanho, pedido.ItensPedido[i].Quantidade);
                        cmd.ExecuteNonQuery();
                    }
                }

                tran.Commit();
            }
            catch (Exception ex)
            {
                if (tran != null)
                {
                    tran.Rollback();
                }
            }
            finally
            {
                conn.Close();
            }
        }

        // PUT api/pedido/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/pedido/5
        public void Delete(int id)
        {
        }
    }
}
