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

@RestController
//@Controller
//@ResponseBody
@RequestMapping(value = "/cozinhas")//, produces = MediaType.APPLICATION_JSON_VALUE)

public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar1(){
		System.out.println("LISTAR 1");
		return cozinhaRepository.buscarTodos();
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Cozinha> listar2(){
		System.out.println("LISTAR 2");
		return cozinhaRepository.buscarTodos();
	}

	@GetMapping("/{cozinhaid}")
	public Cozinha buscar(@PathVariable() Long cozinhaid) {
		return cozinhaRepository.buscarPorId(cozinhaid);
	}
}
