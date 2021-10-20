package br.com.primeiroProjeto.helloworld.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.primeiroProjeto.helloworld.model.Usuario;
import br.com.primeiroProjeto.helloworld.repository.UsuarioRepository;

public class AtualizacaoUserForm {
	
	@NotNull
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// Método de atualização de senha
	public Usuario atualizar(String userId, UsuarioRepository usuarioRepository) {
		//Lógica para alterar a senha de um usuário específico no BD...
		
		//Usuario user = usuarioRepository.getById(userId);
		
		Optional<Usuario> user = usuarioRepository.findById(userId);
		if (user.isPresent()) {
			user.get().setSenha(this.senha);
			//usuarioRepository.save(user.get());
			return user.get();			
		}
		return null;
	}

}
