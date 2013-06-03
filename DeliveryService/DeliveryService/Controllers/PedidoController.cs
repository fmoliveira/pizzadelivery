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
        private string connstr = "Data Source=fmoliveira.com.br; User Id=fmoenguser; Password=%fM0#3nG!h05T7!!@; Initial Catalog=fmoeng;";

        // GET api/pedido
        public IEnumerable<Pedido> Get(int id)
        {
            DateTime min = new DateTime(1970, 1, 1, 0, 0, 0);
            min = min.AddSeconds(id);

            SqlConnection conn = new SqlConnection(connstr);
            SqlCommand cmd = null;
            SqlDataReader reader = null;

            List<Pedido> lista = new List<Pedido>();

            try
            {
                Pedido p = null;
                int ped = 0;
                conn.Open();

                cmd = conn.CreateCommand();
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT p.PedidoId, p.Data, p.Espera, p.NomeCliente, p.Telefone, p.Endereco, p.Bairro, p.FormaPagto, p.TrocoPara, i.Id, i.Tipo, i.Tamanho, i.Quantidade, i.ValorUnitario FROM [PizzaDelivery.Pedidos] AS p INNER JOIN [PizzaDelivery.PedidosItens] AS i ON i.PedidoId = p.PedidoId WHERE p.Data > @Data ORDER BY p.PedidoId, i.Indice;";
                cmd.Parameters.AddWithValue("@Data", min);
                reader = cmd.ExecuteReader();

                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        ped = (int)reader["PedidoId"];

                        if (p == null || p.PedidoId != ped)
                        {
                            if (p != null)
                            {
                                lista.Add(p);
                            }

                            p = new Pedido();
                            p.PedidoId = ped;
                            p.Data = (DateTime)reader["Data"];
                            p.Espera = 45; // (int)reader["Espera"];
                            p.NomeCliente = reader["NomeCliente"].ToString();
                            p.Telefone = reader["Telefone"].ToString();
                            p.Endereco = reader["Endereco"].ToString();
                            p.Bairro = reader["Bairro"].ToString();
                            p.FormaPagto = (int)reader["FormaPagto"];
                            p.TrocoPara = double.Parse((reader["TrocoPara"].ToString()));
                            p.ValorTotal = 0.0;
                            p.ItensPedido = new List<ItemPedido>();
                        }

                        ItemPedido item = new ItemPedido();
                        item.Id = (int)reader["Id"];
                        item.Tipo = (int)reader["Tipo"];
                        item.Tamanho = (int)reader["Tamanho"];
                        item.Quantidade = (int)reader["Quantidade"];
                        item.ValorUnitario = double.Parse((reader["ValorUnitario"].ToString()));
                        item.SubTotal = (item.Quantidade * item.ValorUnitario);
                        p.ValorTotal += item.SubTotal;
                        p.ItensPedido.Add(item);
                    }

                    if (p != null)
                    {
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

        // POST api/pedido
        public HttpResponseMessage Post(Pedido pedido)
        {
            SqlConnection conn = new SqlConnection(connstr);
            SqlTransaction tran = null;
            SqlCommand cmd = null;
            HttpResponseMessage msg = null;

            try
            {
                conn.Open();
                tran = conn.BeginTransaction();
                cmd = conn.CreateCommand();
                cmd.CommandType = CommandType.Text;
                cmd.Transaction = tran;

                TimeZoneInfo brt = TimeZoneInfo.FindSystemTimeZoneById("E. South America Standard Time");
                DateTime utc = DateTime.UtcNow;
                DateTime dataPedido = TimeZoneInfo.ConvertTimeFromUtc(utc, brt);

                cmd.CommandText = string.Format("INSERT INTO [PizzaDelivery.Pedidos] (Data, NomeCliente, Telefone, Endereco, Bairro, FormaPagto, TrocoPara, Espera) VALUES ('{0:yyyy-MM-dd HH:mm:ss}', '{1}', '{6}', '{2}', '{3}', {4}, {5}, 45);", dataPedido, pedido.NomeCliente, pedido.Endereco, pedido.Bairro, pedido.FormaPagto, pedido.TrocoPara, pedido.Telefone);
                cmd.ExecuteNonQuery();

                object o;
                int id = 0;
                cmd.CommandText = "SELECT MAX(PedidoId) FROM [PizzaDelivery.Pedidos];";
                o = cmd.ExecuteScalar();

                if (o != null && o is int)
                {
                    id = (int)o;

                    for (int i = 0; i < pedido.ItensPedido.Count; i++)
                    {
                        cmd.CommandText = string.Format("INSERT INTO [PizzaDelivery.PedidosItens] (PedidoId, Indice, Id, Tipo, Tamanho, Quantidade, ValorUnitario) VALUES ({0}, {1}, {2}, {3}, {4}, {5}, {6});", id, i + 1, pedido.ItensPedido[i].Id, pedido.ItensPedido[i].Tipo, pedido.ItensPedido[i].Tamanho, pedido.ItensPedido[i].Quantidade, pedido.ItensPedido[i].ValorUnitario.ToString().Replace(",", "."));
                        cmd.ExecuteNonQuery();
                    }
                }

                tran.Commit();
                msg = new HttpResponseMessage(HttpStatusCode.Created);
            }
            catch (Exception)
            {
                if (tran != null)
                {
                    tran.Rollback();
                }

                msg = new HttpResponseMessage(HttpStatusCode.InternalServerError);
            }
            finally
            {
                conn.Close();

                if (msg == null)
                {
                    msg = new HttpResponseMessage(HttpStatusCode.BadRequest);
                }
            }

            return msg;
        }
    }
}
