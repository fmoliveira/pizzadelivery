package com.example.pizzadelivery;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

public final class Pedido {
	
	public String NomeCliente = "";

    public String Telefone = "";

    public String Endereco = "";

    public String Bairro  = "";
    
    public int FormaPagto = 0;
    
    public double TrocoPara = 0;
	
	public List<ItemPedido> ItensPedido = null;
	
	private static Pedido mMeuPedido = null; 
	
	public static Pedido getInstancia()
	{
		if (mMeuPedido == null)
		{
			mMeuPedido = new Pedido();
		}
		
		return mMeuPedido;
	}
	
	public static List<ItemPedido> getMeuPedido()
	{
		return getInstancia().ItensPedido;
	}
	
	private static double mValorTotal = 0.0;
	
	public static double getValorTotal()
	{
		return mValorTotal;
	}
	
	private Pedido()
	{
		this.ItensPedido = new ArrayList<ItemPedido>();
	}
	
	public static void addItem(int tipo, int id, int tamanho)
	{
		int i;
		ItemPedido item = null;
		
		if (getMeuPedido() != null)
		{
			for (i = 0; i < getMeuPedido().size(); i++)
			{
				item = getMeuPedido().get(i);
				
				if (item.getTipo() == tipo)
				{
					if (item.getId() == id)
					{
						if (item.getTamanho() == tamanho)
						{
							item.setQuantidade(item.getQuantidade() + 1);
							mValorTotal += item.getValorUnitario();
							return;
						}
					}
				}
			}
		}
		else
		{
			resetarPedido();
		}
		
		if (tipo == TiposPedido.Pizza.getTipoPedido())
		{
			item = new Pizza(id, tamanho);
		}
		else if (tipo == TiposPedido.Bebida.getTipoPedido())
		{
			item = new Bebida(id);
		}
		
		if (item != null)
		{
			item.setQuantidade(1);
			mValorTotal += item.getValorUnitario();
			getMeuPedido().add(item);
		}
	}

	public static void alterarItem(ItemPedido ch, int quantidade)
	{
		int i;
		ItemPedido item;
		
		if (getMeuPedido() != null)
		{
			for (i = 0; i < getMeuPedido().size(); i++)
			{
				item = getMeuPedido().get(i);
				
				if (item.getTipo() == ch.getTipo())
				{
					if (item.getId() == ch.getId())
					{
						if (item.getTamanho() == ch.getTamanho())
						{
							item.setQuantidade(quantidade);
							return;
						}
					}
				}
			}
		}
	}
	
	public static void removerItem(ItemPedido rm)
	{
		int i;
		ItemPedido item;
		
		if (getMeuPedido() != null)
		{
			for (i = 0; i < getMeuPedido().size(); i++)
			{
				item = getMeuPedido().get(i);
				
				if (item.getTipo() == rm.getTipo())
				{
					if (item.getId() == rm.getId())
					{
						if (item.getTamanho() == rm.getTamanho())
						{
							getMeuPedido().remove(i);
							return;
						}
					}
				}
			}
		}
	}
	
	public static void resetarPedido()
	{
		getInstancia().NomeCliente = "";
		getInstancia().Telefone = "";
		getInstancia().Endereco = "";
		getInstancia().Bairro = "";
		getInstancia().FormaPagto = 0;
		getInstancia().TrocoPara = 0.0;
		getMeuPedido().clear();
		mValorTotal = 0.0;
	}

	@Override
	public String toString()
	{
		return String.format("Pedido [NomeCliente=%s, Telefone=%s, Endereco=%s, Bairro=%s, FormaPagto=%d, TrocoPara=%f, ItensPedido=%s]", this.NomeCliente, this.Telefone, this.Endereco, this.Bairro, this.FormaPagto, this.TrocoPara, this.ItensPedido);
	}
}
