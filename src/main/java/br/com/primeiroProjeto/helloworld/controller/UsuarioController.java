package br.com.primeiroProjeto.helloworld.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.primeiroProjeto.helloworld.dto.UsuarioDTO;
import br.com.primeiroProjeto.helloworld.form.AtualizacaoUserForm;
import br.com.primeiroProjeto.helloworld.form.EnderecoForm;
import br.com.primeiroProjeto.helloworld.form.UsuarioForm;
import br.com.primeiroProjeto.helloworld.model.Endereco;
import br.com.primeiroProjeto.helloworld.model.Usuario;
import br.com.primeiroProjeto.helloworld.repository.EnderecoRepository;
import br.com.primeiroProjeto.helloworld.repository.UsuarioRepository;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public List<UsuarioDTO> listar(String cep, String tipo) {

		System.out.println("Tipo: " + cep);
		System.out.println("Tipo: " + tipo);
		// Usuario user = new Usuario("XPTO2", "1234", "Emanuelly", "999.999.999-99",
		// "Programador");
		// return UsuarioDTO.converter(Arrays.asList(user, user, user, user));

		List<Usuario> usuarios;

		if (cep == null || tipo == null) {
			// usuarios = usuarioRepository.findAll();
			usuarios = usuarioRepository.buscarTodos();
		} else {
			// usuarios = usuarioRepository.findByTipo(tipo);
			// usuarios = usuarioRepository.buscarPorTipo(tipo);
			usuarios = usuarioRepository.findByEndereco_Cep(cep);
		}
		return UsuarioDTO.converter(usuarios);
	}

	@GetMapping("/tipo")
	public List<UsuarioDTO> listarPorTipoECpf(String tipo, String cpf) {
		System.out.println("Listar todos pelo Tipo e um CPF: " + tipo + " - " + cpf);
		List<Usuario> usuarios;
		usuarios = usuarioRepository.buscarTodosPorTipo(tipo, cpf);
		return UsuarioDTO.converter(usuarios);
	}

	// Receber mais de um paramentro em rota dinâmica
	@GetMapping("/{userId}")
	public ResponseEntity<UsuarioDTO> buscarUser(@PathVariable String userId, String cep, String tipo) {
		System.out.println("---------> UserId: " + userId);
		System.out.println("---------> cep: " + cep);
		System.out.println("---------> tipo: " + tipo);

		// Lógica para buscar usuário no BD...
		Optional<Usuario> userOp = usuarioRepository.findById(userId);

		// testar se tem alguma coisa dentro do userOp
		if (userOp.isPresent()) {
			return ResponseEntity.ok(UsuarioDTO.converterUser(userOp.get()));
		}
		// retornar uma mensagem de não encontrado o userOp: 404
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid UsuarioForm userForm,
			UriComponentsBuilder uriBuilder) {
		Usuario user = userForm.converter();
		usuarioRepository.save(user);

		// URI = caminho.
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri();

		// retorna além do status de sucesso, o created o caminho onde acessar esse novo
		// atributo
		return ResponseEntity.created(uri).body(new UsuarioDTO(user));

	}

	@PostMapping("/cadEndereco")
	@Transactional
	public Endereco salvarEndereco(@RequestBody @Valid EnderecoForm endForm) {
		Endereco end = endForm.converter();
		enderecoRepository.save(end);
		return end;
	}

	@PutMapping("/{userId}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable String userId,
			@RequestBody @Valid AtualizacaoUserForm userForm) {
		// Lógica para atualizar usuário no BD...
		Usuario user = userForm.atualizar(userId, usuarioRepository);

		// testar se tem alguma coisa dentro do user
		if (user != null) {
			return ResponseEntity.ok(new UsuarioDTO(user));
		}
		// retornar uma mensagem de não encontrado o user: 404
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{userId}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable String userId) {

		// Procurar um usuário com o ID enviado...
		Optional<Usuario> userOp = usuarioRepository.findById(userId);

		// Verificação se o usuário foi encontrado...
		if (userOp.isPresent()) {
			// Lógica para deletar usuário no BD...
			usuarioRepository.deleteById(userId);
			// Apenas mensagem de que deu certo deletar o usuário
			return ResponseEntity.ok().build();
		}
		// retornar uma mensagem de não encontrado o user: 404
		return ResponseEntity.notFound().build();
	}

}
