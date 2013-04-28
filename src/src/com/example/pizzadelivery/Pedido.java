package com.example.pizzadelivery;

import java.util.ArrayList;
import java.util.List;

public final class Pedido {
	
	private static List<ItemPedido> mMeuPedido;
	
	public static List<ItemPedido> getMeuPedido()
	{
		return mMeuPedido;
	}
	
	private Pedido()
	{
		//
	}
	
	public static void addPizza(int id, int tamanho)
	{
		int i;
		ItemPedido item;
		TiposPedido tipo;
		
		if (mMeuPedido != null)
		{
			for (i = 0; i < mMeuPedido.size(); i++)
			{
				item = mMeuPedido.get(i);
				tipo = TiposPedido.values()[item.getTipo()];
				
				if (tipo == TiposPedido.Pizza)
				{
					if (item.getId() == id)
					{
						if (item.getTamanho() == tamanho)
						{
							item.setQuantidade(item.getQuantidade() + 1);
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
		
		item = new Pizza(id, tamanho);
		item.setQuantidade(1);
		mMeuPedido.add(item);
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
	}
	
}
