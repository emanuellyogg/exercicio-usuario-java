package br.com.primeiroProjeto.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.primeiroProjeto.helloworld.model.*;

// Herança / <tipo de dado, e tipo da chave>
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	List<Usuario> findByTipo(String tipo);

	List<Usuario> findByEndereco_Cep(String enderecoCep);

	//É possível criar método de buscas, mesmo foram do "padrão" do string boot
	
	// JPQL: Java Peristence Query Language
	@Query("Select u from Usuario u where u.tipo = :tipo")
	List<Usuario> buscarPorTipo(@Param("tipo") String tipo);

	@Query(value="Select * from usuario", nativeQuery=true)
	List<Usuario> buscarTodos();
	
	@Query(value="Select * from usuario where tipo = :tipo and cpf = :cpf", nativeQuery=true)
	List<Usuario> buscarTodosPorTipo(@Param("tipo")String tipo, @Param("cpf")String cpf);


}
