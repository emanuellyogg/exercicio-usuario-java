package br.com.primeiroProjeto.helloworld.form;

import javax.validation.constraints.NotNull;

import br.com.primeiroProjeto.helloworld.model.Endereco;

public class EnderecoForm {

	@NotNull
	private int endcod;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	public int getEndcod() {
		return endcod;
	}

	public void setEndcod(int endcod) {
		this.endcod = endcod;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Endereco converter() {
		return new Endereco(endcod, rua, numero, complemento, bairro, cep, cidade, estado);
	}

}
