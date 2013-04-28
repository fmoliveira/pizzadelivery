package com.example.pizzadelivery;

public enum TamanhosPizza {

	Grande(0), Gigante(1);
	
	private final int mTamanhoPizza;
	
	TamanhosPizza()
	{
		this.mTamanhoPizza = 0;
	}
	
	TamanhosPizza(int tipo)
	{
		this.mTamanhoPizza = tipo;
	}
	
	public int getTamanhoPizza()
	{
		return this.mTamanhoPizza;
	}
	
	public String getDescricao()
	{
		TamanhosPizza tamanho = TamanhosPizza.values()[this.mTamanhoPizza];
		
		switch (tamanho)
		{
			case Grande:
				return "Grande";
				
			case Gigante:
				return "Gigante";
				
			default:
				return "(Tamanho inválido)";
		}
	}
	
}
