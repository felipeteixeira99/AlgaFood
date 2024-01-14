package com.algaWorks.algafood.api.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

	/*
	 * @ResponseStatus(HttpStatus.CREATED)
	 * 
	 * @GetMapping("/{cozinhaId}") public ResponseEntity<Cozinha>
	 * buscar(@PathVariable Long cozinhaId) { Cozinha cozinha =
	 * cozinhaRepository.buscarPorId(cozinhaId); // return
	 * ResponseEntity.status(HttpStatus.OK).body(cozinha); //retorna a requisição
	 * com o corpo da resposta // return
	 * ResponseEntity.status(HttpStatus.OK).build(); //retorna a requisição sem o
	 * corpo da resposta // return ResponseEntity.ok(cozinha); //retorna a
	 * requisição com o corpo da resposta // return ResponseEntity.ok(cozinha);
	 * 
	 * org.springframework.http.HttpHeaders headers = new
	 * org.springframework.http.HttpHeaders();
	 * headers.add(org.springframework.http.HttpHeaders.LOCATION,
	 * "http://api.algafood.local:8080/cozinhas");
	 * 
	 * return ResponseEntity .status(HttpStatus.FOUND) .headers(headers) .build(); }
	 */
	

	@GetMapping
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){
		Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId);
		
		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		//return ResponseEntity<Cozinha.status(HttpStatus.NOT_FOUND);
	   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	 
	
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(cozinhaRepository.buscarTodos());
		
	}
}

