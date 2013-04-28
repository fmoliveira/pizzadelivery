package com.example.pizzadelivery;

public class ItemPedido {

	protected int Id = 0;
	protected int Tipo = 0;
	protected int Tamanho = 0;
	protected int Quantidade = 0;
	
	protected ItemPedido()
	{
		//
	}
	
	public ItemPedido(int id, int tipo, int tamanho)
	{
		this.Id = id;
		this.Tamanho = tamanho;
	}
	
	public int getId()
	{
		return this.Id;
	}
	
	public int getTipo()
	{
		return this.Tipo;
	}
	
	public int getTamanho()
	{
		return this.Tamanho;
	}
	
	public int getQuantidade()
	{
		return this.Quantidade;
	}
	
	public double getValorUnitario()
	{
		return TabelaPrecos.getValorUnitario(this.getTipo(), this.getId(), this.getTamanho());
	}
	
	public void setQuantidade(int quantidade)
	{
		this.Quantidade = quantidade;
	}
	
	public double getSubtotal()
	{
		return (this.getQuantidade() * this.getValorUnitario());
	}

	public String getDescricao()
	{
		String s;
		TiposPedido tipo = TiposPedido.values()[this.Tipo];
		
		if (tipo == TiposPedido.Pizza)
		{
			s = String.format("%s (%s)"
						, SaboresPizza.values()[this.Id].getNome()
						, TamanhosPizza.values()[this.Tamanho].getDescricao()
					);
		}
		else if (this.Tipo == TiposPedido.Bebida.getTipoPedido())
		{
			s = "Bebida";
		}
		else
		{
			s = "(Item inválido)";
		}
		
		return s;
	}
	
	public String toString()
	{
		return getDescricao();
	}
	
}
