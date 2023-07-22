package com.algaWorks.algafood.domain.repository;

import java.util.List;

import com.algaWorks.algafood.domain.model.FormaDePagamento;
import com.algaWorks.algafood.domain.model.Restaurante;

public interface FormaDePagamentoRepository {
	
	List<FormaDePagamento> buscarTodos();
	FormaDePagamento buscarPorId(Long id);
	FormaDePagamento adicionar(FormaDePagamento formaPagamento);
	void deletar(FormaDePagamento formaPagamento);
	
}
