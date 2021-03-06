package com.example.pizzadelivery;

public class TabelaPrecos {
	
	public static double []mPrecosPizzasGrandes =
	{
		50, 51, 52, 53, 54, 55
	};
	
	public static double []mPrecosPizzasGigantes =
	{
		60, 61, 62, 63, 64, 65
	};
	
	public static double []mPrecosBebidas =
	{
		5, 5, 4.5, 4.5, 6.3, 6.2
	};
	
	public static double getValorUnitario(int tipo, int id, int tamanho)
	{
		TiposPedido tp = TiposPedido.values()[tipo];
		
		if (tp == TiposPedido.Pizza)
		{
			TamanhosPizza tam = TamanhosPizza.values()[tamanho];
			
			if (tam == TamanhosPizza.Grande)
			{
				return mPrecosPizzasGrandes[id];
			}
			else if (tam == TamanhosPizza.Gigante)
			{
				return mPrecosPizzasGigantes[id];
			}
		}
		else if (tp == TiposPedido.Bebida)
		{
			return mPrecosBebidas[id];
		}
		
		return 0;
	}
	
}
