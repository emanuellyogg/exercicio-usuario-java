package br.com.primeiroProjeto.helloworld.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.primeiroProjeto.helloworld.model.Usuario;

public class UsuarioDTO {

	private String userId;
	private String nome;

	public UsuarioDTO(Usuario usuario) {
		this.userId = usuario.getUserId();
		this.nome = usuario.getNome();
	}

	public String getUserId() {
		return userId;
	}

	public String getNome() {
		return nome;
	}

	// Static manter na memoria da classe e não do objeto
	// Converter o Objeto para o DTO
	public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
	public static UsuarioDTO converterUser(Usuario usuario) {
		return new UsuarioDTO(usuario);
	}

}
