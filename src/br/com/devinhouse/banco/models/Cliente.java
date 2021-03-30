package br.com.devinhouse.banco.models;

public class Cliente {
	String nome;
	String sobrenome;
	String cpf;
	Endereco endereco;
	
	Cliente(String nome, String sobrenome, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}
	
	/*
	 * Cliente(String nome, String sobrenome, String cpf, String
	 * logradouroResidencia, String numeroResidencia, String complementoResidencia,
	 * String cepResidencia) { this(nome, sobrenome, cpf); this.endereco = new
	 * Endereco(); this.endereco.logradouro = logradouroResidencia;
	 * this.endereco.numero = numeroResidencia; this.endereco.cep = cepResidencia;
	 * this.endereco.complemento = complementoResidencia; }
	 */
	
}
