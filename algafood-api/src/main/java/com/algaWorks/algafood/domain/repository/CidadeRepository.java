package com.algaWorks.algafood.domain.repository;

import java.util.List;

import com.algaWorks.algafood.domain.model.Cidade;

public interface CidadeRepository {
	
	List<Cidade> buscarTodos();
	Cidade buscarPorId(Long id);
	Cidade adicionar(Cidade cidade);
	void deletar(Cidade cidade);
}
