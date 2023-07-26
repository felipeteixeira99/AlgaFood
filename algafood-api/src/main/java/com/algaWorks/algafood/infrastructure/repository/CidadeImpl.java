package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Cidade adicionar(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}

}
