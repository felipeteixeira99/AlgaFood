package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaImpl implements CozinhaRepository {
	
	@PersistenceContext
	private EntityManager gerenciador;
	

	@Override
	public List<Cozinha> buscarTodos() {
		return gerenciador.createQuery("from Cozinha",Cozinha.class)
				.getResultList();
	}

	@Override
	public Cozinha buscarPorId(Long id) {
		return gerenciador.find(Cozinha.class, id);
	}

	@Override
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		gerenciador.merge(cozinha);
		return null;
	}

	@Override
	@Transactional
	public void deletar(Cozinha cozinha) {
		cozinha = buscarPorId(cozinha.getId());
		gerenciador.remove(cozinha);
	}
}
