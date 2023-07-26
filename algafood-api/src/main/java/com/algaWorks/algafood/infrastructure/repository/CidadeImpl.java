package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Cidade;
import com.algaWorks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeImpl implements CidadeRepository{
	
	@PersistenceContext
	private EntityManager gerenciador;

	@Override
	public List<Cidade> buscarTodos() {
		return gerenciador.createQuery("from Cidade",Cidade.class)
				.getResultList();
	}

	@Override
	public Cidade buscarPorId(Long id) {
		return gerenciador.find(Cidade.class, id);
	}

	@Override
	@Transactional
	public Cidade adicionar(Cidade cidade) {
		return gerenciador.merge(cidade);
	}

	@Override
	@Transactional
	public void deletar(Cidade cidade) {
		cidade = buscarPorId(cidade.getId());
		gerenciador.remove(cidade);
	}

}
