package com.algaWorks.algafood.domain.repository;

import java.util.List;

import com.algaWorks.algafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listarTodos();
	Estado buscarPorId(Long id);
	Estado adicionar(Estado estado);
	void deletar(Estado estado);

}
