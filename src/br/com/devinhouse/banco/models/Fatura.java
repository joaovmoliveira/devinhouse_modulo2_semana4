package br.com.devinhouse.banco.models;

public class Fatura {
	
	private String numero;
	private String descricao;
	private int quantidade;
	private double preco;
	
	public Fatura(String numero, String descricao, int quantidade, double preco) {
		this.numero = numero;
		this.descricao = descricao;
		
		this.quantidade = (int) validaNumericoPositivo(quantidade);
		this.preco = validaNumericoPositivo(preco);
	}
	
	private double validaNumericoPositivo(double valorNumerico) {
		if (valorNumerico < 0) {
			return 0;
		} else {
			return valorNumerico;
		}
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = (int) validaNumericoPositivo(quantidade);
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = validaNumericoPositivo(preco);
	}
	
	public double getValorFatura() {
		return this.preco * this.quantidade;
	}
	
	public int soma(int a, int b) {
		return a + b;
	}
	
	public double soma(double a, double b) {
		return a + b;
	}
	
	

}
