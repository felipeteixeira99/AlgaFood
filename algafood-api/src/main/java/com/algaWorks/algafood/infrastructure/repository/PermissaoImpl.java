package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Permissoes;
import com.algaWorks.algafood.domain.repository.PermissoesRepository;

@Component
public class PermissaoImpl implements PermissoesRepository {
	
	@PersistenceContext
	private EntityManager gerenciador;

	@Override
	public List<Permissoes> listar(){
		return gerenciador.createQuery("from Permisoes", Permissoes.class)
				.getResultList();
	}

	@Override
	public Permissoes buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permissoes adcionar(Permissoes permissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Permissoes permissao) {
		// TODO Auto-generated method stub
		
	}

}
