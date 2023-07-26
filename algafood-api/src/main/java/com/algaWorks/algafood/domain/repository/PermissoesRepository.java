package com.algaWorks.algafood.domain.repository;

import java.util.List;

import com.algaWorks.algafood.domain.model.Permissoes;

public interface PermissoesRepository {
	
	List<Permissoes> listar();
	Permissoes buscarPorId(Long id);
	Permissoes adcionar(Permissoes permissao);
	void deletar(Permissoes permissao);
}
