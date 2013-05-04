package com.example.pizzadelivery;

import java.util.ArrayList;
import java.util.List;

public final class Pedido {
	
	private static List<ItemPedido> mMeuPedido;
	
	public static List<ItemPedido> getMeuPedido()
	{
		return mMeuPedido;
	}
	
	private static double mValorTotal = 0.0;
	
	public static double getValorTotal()
	{
		return mValorTotal;
	}
	
	private Pedido()
	{
		//
	}
	
	public static void addItem(int tipo, int id, int tamanho)
	{
		int i;
		ItemPedido item = null;
		
		if (mMeuPedido != null)
		{
			for (i = 0; i < mMeuPedido.size(); i++)
			{
				item = mMeuPedido.get(i);
				
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
			mMeuPedido.add(item);
		}
	}

	public static void alterarItem(ItemPedido ch, int quantidade)
	{
		int i;
		ItemPedido item;
		
		if (mMeuPedido != null)
		{
			for (i = 0; i < mMeuPedido.size(); i++)
			{
				item = mMeuPedido.get(i);
				
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
		
		if (mMeuPedido != null)
		{
			for (i = 0; i < mMeuPedido.size(); i++)
			{
				item = mMeuPedido.get(i);
				
				if (item.getTipo() == rm.getTipo())
				{
					if (item.getId() == rm.getId())
					{
						if (item.getTamanho() == rm.getTamanho())
						{
							mMeuPedido.remove(i);
							return;
						}
					}
				}
			}
		}
	}
	
	public static void resetarPedido()
	{
		if (mMeuPedido == null)
		{
			mMeuPedido = new ArrayList<ItemPedido>();
		}
		else
		{
			mMeuPedido.clear();
		}
		mValorTotal = 0.0;
	}
	
}
