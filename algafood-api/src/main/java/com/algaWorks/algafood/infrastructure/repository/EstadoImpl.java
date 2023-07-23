package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import com.algaWorks.algafood.domain.model.Estado;
import com.algaWorks.algafood.domain.repository.EstadoRepository;

public class EstadoImpl implements EstadoRepository {
	
	@PersistenceContext
	private EntityManager gerenciador;
	
	@Override
	public List<Estado> listarTodos() {
		return gerenciador.createQuery("from Estado", Estado.class)
				.getResultList();
	}

	@Override
	public Estado buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado adicionar(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Estado estado) {
		// TODO Auto-generated method stub
		
	}

}
