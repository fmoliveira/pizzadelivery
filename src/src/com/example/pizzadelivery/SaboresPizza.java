package com.example.pizzadelivery;

public enum SaboresPizza {

	Calabresa(0), Coreana(1), CornBacon(2), Country(3), Marguerita(4), Supreme(5);
	
	public static final int getQtdeSabores()
	{
		return 6;
	}
	
	private final int mSabor;
	
	private SaboresPizza()
	{
		this.mSabor = 0;
	}
	
	SaboresPizza(int sabor)
	{
		this.mSabor = sabor;
	}
	
	public int getSaborId()
	{
		return this.mSabor;
	}
	
	public String getNome()
	{
		SaboresPizza sabor = SaboresPizza.values()[this.mSabor];
		
		switch (sabor)
		{
			case Calabresa:
				return "Calabresa";
				
			case Coreana:
				return "Coreana";
				
			case CornBacon:
				return "Corn & Bacon";
				
			case Country:
				return "Country";
				
			case Marguerita:
				return "Marguerita";
				
			case Supreme:
				return "Supreme";
				
			default:
				return "(Sabor inválido)";
		}
	}
	
	public String getDescricao()
	{
		SaboresPizza sabor = SaboresPizza.values()[this.mSabor];
		
		switch (sabor)
		{
			case Calabresa:
				return "Calabresa, mussarela, cebola e azeitonas.";
				
			case Coreana:
				return "Queijo cheddar cremoso, frango, champignon e mussarela.";
				
			case CornBacon:
				return "Milho, bacon e mussarela.";
				
			case Country:
				return "Mussarela, frango, bacon e cream cheese.";
				
			case Marguerita:
				return "Mussarela, manjericão, tomate e requeijão cremoso.";
				
			case Supreme:
				return "Carnes bovina e suína, pepperoni, mussarela, champignon, pimentão e cebola.";
				
			default:
				return "(Sem descrição)";
		}
	}
	
}
