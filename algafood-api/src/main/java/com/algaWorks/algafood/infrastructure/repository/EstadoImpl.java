package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Estado;
import com.algaWorks.algafood.domain.repository.EstadoRepository;

@Component
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
		return gerenciador.find(Estado.class, id);
	}

	@Override
	@Transactional
	public Estado adicionar(Estado estado) {
		return gerenciador.merge(estado);
	}

	@Override
	@Transactional
	public void deletar(Estado estado) {
		estado = buscarPorId(estado.getId());
		gerenciador.remove(estado);
	}

}
