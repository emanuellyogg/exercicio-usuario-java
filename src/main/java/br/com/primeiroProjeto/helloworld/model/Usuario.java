package br.com.primeiroProjeto.helloworld.model;

import javax.persistence.*;

@Entity
public class Usuario {

	// Gerador de chave, que é o ID do Usuario
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// Chave primária que vai identificar o Usuario, neste caso é o userId:
	@Id
	private String userId;
	private String senha;
	private String nome;
	private String cpf;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

	public Usuario() {
	}

	public Usuario(String userId, String senha, String nome, String cpf, String tipo, Endereco endereco) {
		this.userId = userId;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
		this.endereco = endereco;
	}

	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
