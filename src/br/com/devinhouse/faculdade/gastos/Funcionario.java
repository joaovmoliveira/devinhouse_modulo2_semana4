package br.com.devinhouse.faculdade.gastos;

public abstract class Funcionario {
	private String nome;
	private double salario;

	public Funcionario() {
	}

	public abstract double getGastos();

	public String getInfo() {
		return String.format("Nome: %s com salário de R$ %.2f.", this.nome, this.salario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
