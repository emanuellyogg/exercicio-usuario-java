package br.com.primeiroProjeto.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller para dizer que será um mapeamento de rotas
@Controller
public class HelloController {
	
	// aqui estou dizendo em qual rota será "/"
	//ResponseBody é o retorno no corpo da resposta, ou seja, no Body do HTML (navegador)
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}

}
