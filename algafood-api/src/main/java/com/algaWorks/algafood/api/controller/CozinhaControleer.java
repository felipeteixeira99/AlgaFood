package com.algaWorks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.domain.repository.CozinhaRepository;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/cozinhas")

public class CozinhaControleer {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.buscarTodos();
	}
}
