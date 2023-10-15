package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cozinha adicionar(Cozinha cozinha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Cozinha cozinha) {
		// TODO Auto-generated method stub
		
	}
	
	

}
