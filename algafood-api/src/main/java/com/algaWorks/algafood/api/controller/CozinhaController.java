package com.algaWorks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.domain.repository.CozinhaRepository;

//Modelagem Rest API
//Essa classe serve para que todas as requisições com a URI /cozinhas caiam nesse controlador


//@Controller //Componente spring do tipo controlador
//@ResponseBody //
@RestController //Possui o Controller e o ResponseBody
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE) //Mapeamento do controlador responsavel pelas as requisições especificando a URI desse controlador
//colocando o produces na classe, ele vai pergar todo o escopo da classe
public class CozinhaController {
	
	@Autowired  
	private CozinhaRepository cozinhaRepository; //variavel de instancia que implementa a interface de Cozinha
	
	@GetMapping()//Significa que requisições com o verbo HTTP Get irão cair nesse metodo
	public List<Cozinha> listarCozinha(){  //metodo que recebe e retorna a listagem de cozinhas salvas no banco
		return cozinhaRepository.buscarTodos();
	}
	
	//Retorna uma cozinha conforme ID passado no parametro
	//A anotação pathvariable atribui a variavel passada no getmapping para o id, e o mesmo é retornado no fim do metodo
	@GetMapping("/{cozinhaId}")
	public Cozinha buscarCozinhaId(@PathVariable Long cozinhaId) {
		return cozinhaRepository.buscarPorId(cozinhaId);
	}

}
