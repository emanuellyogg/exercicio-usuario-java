package br.com.primeiroProjeto.helloworld.form;

import javax.validation.constraints.NotNull;

import br.com.primeiroProjeto.helloworld.model.Endereco;
import br.com.primeiroProjeto.helloworld.model.Usuario;

public class UsuarioForm {

	@NotNull
	private String userId;
	private String senha;
	private String nome;
	private String cpf;
	private String tipo;
	private Endereco endereco;

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
	
	// Método que vai converter os dados do UsuarioForm para Usuario
	public Usuario converter() {
		return new Usuario(userId, senha, nome, cpf, tipo, endereco);
	}
}
