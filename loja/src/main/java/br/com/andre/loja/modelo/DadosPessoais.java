package br.com.andre.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais implements Serializable {

	private String nome;
	private String cpf;
	

	
	
	public DadosPessoais() {
		super();
	}




	public DadosPessoais(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}




	public String getNome() {
		return nome;
	}




	public String getCpf() {
		return cpf;
	}




	
}
