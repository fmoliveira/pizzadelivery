package com.example.pizzadelivery;

public class ItemPedido {

	protected int Id = 0;
	protected int Tipo = 0;
	protected int Tamanho = 0;
	protected int Quantidade = 0;
	protected double ValorUnitario = 0.0;
	
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
		if (ValorUnitario == 0.0)
		{
			this.ValorUnitario = TabelaPrecos.getValorUnitario(this.getTipo(), this.getId(), this.getTamanho());
		}
		return this.ValorUnitario;
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
			s = String.format("%s"
					, TiposBebidas.values()[this.Id].getNome()
				);
		}
		else
		{
			s = "(Item inv�lido)";
		}
		
		return s;
	}
	
	@Override
	public String toString()
	{
		return String.format("ItemPedido [Id=%d, Tipo=%d, Tamanho=%d, Quantidade=%d, ValorUnitario=%f]", this.getId(), this.getTipo(), this.getTamanho(), this.getQuantidade(), this.getValorUnitario());
	}

	public Integer getKey() {
		return ((this.getId() + 1) * (this.getTipo() + 1) * (this.getTamanho() + 1));
	}
	
}
