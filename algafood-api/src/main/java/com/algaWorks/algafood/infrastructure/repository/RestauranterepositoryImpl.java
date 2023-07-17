package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Restaurante;
import com.algaWorks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranterepositoryImpl implements RestauranteRepository {
	
	
	@PersistenceContext
	private EntityManager gerenciador;
	

	@Override
	public List<Restaurante> trazerTodos() {
		return gerenciador.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}

	@Override
	public Restaurante buscarPorId(Long id) {
		return gerenciador.find(Restaurante.class,id);
	}

	@Override
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return gerenciador.merge(restaurante);
	}

	@Override
	@Transactional
	public void deletar(Restaurante restaurante) {
		restaurante = buscarPorId(restaurante.getId());
		gerenciador.remove(restaurante);
	}


}
