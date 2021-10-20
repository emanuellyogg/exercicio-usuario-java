package br.com.primeiroProjeto.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeiroProjeto.helloworld.model.*;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
