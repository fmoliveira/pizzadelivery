package com.example.pizzadelivery;

public class Pizza {
	
	private int Id = 0;
	private int Tamanho = 0;
	private int Quantidade = 0;
	
	public Pizza(int id, int tamanho)
	{
		this.Id = id;
		this.Tamanho = tamanho;
		this.Quantidade = 0;
	}
	
	public int getId()
	{
		return this.Id;
	}
	
	public int getTamanho()
	{
		return this.Tamanho;
	}
	
	public int getQuantidade()
	{
		return this.Quantidade;
	}
	
	public void setQuantidade(int quantidade)
	{
		this.Quantidade = quantidade;
	}
	
}
