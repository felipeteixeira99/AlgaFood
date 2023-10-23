package com.algaWorks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaWorks.algafood.domain.model.Estado;
import com.algaWorks.algafood.domain.repository.EstadoRepository;
import com.algaWorks.algafood.infrastructure.repository.CozinhaImpl;
import com.algaWorks.algafood.infrastructure.repository.EstadoImpl;

@RestController
@RequestMapping("/estados")
public class EstadosController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.listarTodos();
	}
}
