package com.example.pizzadelivery;

public enum TiposPedido {

	Pizza(0), Bebida(1);
	
	private final int mTipoPedido;
	
	TiposPedido()
	{
		this.mTipoPedido = 0;
	}
	
	TiposPedido(int tipo)
	{
		this.mTipoPedido = tipo;
	}
	
	public int getTipoPedido()
	{
		return this.mTipoPedido;
	}
	
}
