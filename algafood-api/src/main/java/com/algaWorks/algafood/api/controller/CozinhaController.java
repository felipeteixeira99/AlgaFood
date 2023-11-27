package com.algaWorks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.domain.model.CozinhasXmlWrapper;
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
	
	
//	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
//	public List<Cozinha> listar2(){
//		System.out.println("LISTAR 2");
//		return cozinhaRepository.buscarTodos();
//	}

//	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/{cozinhaid}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha  cozinha = cozinhaRepository.buscarPorId(cozinhaId);
		
//		return ResponseEntity.status(HttpStatus.OK).build();
		return ResponseEntity.ok();
		
	}

	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(cozinhaRepository.buscarTodos());
		
	}
}




////@ResponseStatus(HttpStatus.CREATED)
//@GetMapping("/{cozinhaid}")
//public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
//	Cozinha  cozinha = cozinhaRepository.buscarPorId(cozinhaId);
//	return ResponseEntity.status(HttpStatus.OK).body(cozinha);
//	
//}
//
//
//@ResponseStatus(HttpStatus.CREATED)
//@GetMapping("/{cozinhaid}")
//public Cozinha buscar(@PathVariable() Long cozinhaid) {
//	return cozinhaRepository.buscarPorId(cozinhaid);
//}
