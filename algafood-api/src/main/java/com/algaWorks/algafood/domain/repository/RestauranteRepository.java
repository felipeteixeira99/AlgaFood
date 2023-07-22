package com.algaWorks.algafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Restaurante;


public interface RestauranteRepository {
	
	List<Restaurante> trazerTodos();
	Restaurante buscarPorId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void deletar(Restaurante restaurante);

}
