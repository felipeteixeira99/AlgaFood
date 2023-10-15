package com.algaWorks.algafood.domain.repository;

import java.util.List;

import com.algaWorks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> buscarTodos();
	Cozinha buscarPorId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void deletar(Cozinha cozinha);

}
