package com.example.pizzadelivery;

import java.util.ArrayList;
import java.util.List;

public final class Pedido {
	
	public static final Pedido MeuPedido = new Pedido();

	private List<Pizza> Pizzas;
	
	public List<Pizza> getPizzas()
	{
		return Pizzas;
	}
	
	private Pedido()
	{
		ResetarPedido();
	}
	
	public static Pedido getPedido()
	{
		return MeuPedido;
	}
	
	public static void addPizza(int id, int tamanho)
	{
		int i;
		Pizza p;
		
		for (i = 0; i < MeuPedido.Pizzas.size(); i++)
		{
			p = MeuPedido.Pizzas.get(i);
			
			if (p.getId() == id)
			{
				if (p.getTamanho() == tamanho)
				{
					p.setQuantidade(p.getQuantidade() + 1);
					return;
				}
			}
		}
		
		p = new Pizza(id,  tamanho);
		p.setQuantidade(1);
		MeuPedido.Pizzas.add(p);
	}
	
	public void ResetarPedido()
	{
		if (Pizzas == null)
		{
			Pizzas = new ArrayList<Pizza>();
		}
		else
		{
			Pizzas.clear();
		}
	}
	
}
