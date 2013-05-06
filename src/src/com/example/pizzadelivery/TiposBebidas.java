package com.example.pizzadelivery;

public enum TiposBebidas {

	Pepsi(0), PepsiLight(1), Guarana(2), GuaranaZero(3), H2O(4), IceTea(5);
	
	public static final int getQtdeTipos()
	{
		return 6;
	}
	
	private final int mTipo;
	
	private TiposBebidas()
	{
		this.mTipo = 0;
	}
	
	TiposBebidas(int tipo)
	{
		this.mTipo = tipo;
	}
	
	public int getTipoId()
	{
		return this.mTipo;
	}
	
	public String getNome()
	{
		TiposBebidas sabor = TiposBebidas.values()[this.mTipo];
		
		switch (sabor)
		{
			case Pepsi:
				return "Pepsi";
				
			case PepsiLight:
				return "Pepsi Light";
				
			case Guarana:
				return "Guaraná";
				
			case GuaranaZero:
				return "Guaraná Zero";
				
			case H2O:
				return "H2O";
				
			case IceTea:
				return "Ice Tea";
				
			default:
				return "(Bebida inválida)";
		}
	}
	
	public String getDescricao()
	{
		TiposBebidas sabor = TiposBebidas.values()[this.mTipo];
		
		switch (sabor)
		{
			case Pepsi:
				return "Pepsi 2L";
				
			case PepsiLight:
				return "Pepsi Light 2L";
				
			case Guarana:
				return "Guaraná Antarctica 2L";
				
			case GuaranaZero:
				return "Guaraná Antarctica Zero 2L";
				
			case H2O:
				return "H2O Limão 1.5L";
				
			case IceTea:
				return "Lipton Ice Tea 1.5L";
				
			default:
				return "(Bebida inválida)";
		}
	}
	
}
