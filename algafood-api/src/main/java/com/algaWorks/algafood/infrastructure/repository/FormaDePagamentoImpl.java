package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.FormaDePagamento;
import com.algaWorks.algafood.domain.repository.FormaDePagamentoRepository;

@Component
public class FormaDePagamentoImpl implements FormaDePagamentoRepository {
	
	@PersistenceContext
	private EntityManager gerenciador;

	@Override
	public List<FormaDePagamento> buscarTodos() {
		return gerenciador.createQuery("from FormaDePagamento", FormaDePagamento.class)
				.getResultList();
	}

	@Override
	public FormaDePagamento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormaDePagamento adicionar(FormaDePagamento formaPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(FormaDePagamento formaPagamento) {
		// TODO Auto-generated method stub
		
	}

}
