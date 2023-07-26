package com.algaWorks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.domain.model.Permissoes;
import com.algaWorks.algafood.domain.repository.PermissoesRepository;

@Component
public class PermissaoImpl implements PermissoesRepository {
	
	@PersistenceContext
	private EntityManager gerenciador;

	@Override
	public List<Permissoes> listar(){
		return gerenciador.createQuery("from Permissoes", Permissoes.class)
				.getResultList();
	}

	@Override
	public Permissoes buscarPorId(Long id) {
		return gerenciador.find(Permissoes.class, id);
	}

	@Override
	@Transactional
	public Permissoes adcionar(Permissoes permissao) {
		return gerenciador.merge(permissao);

	}

	@Override
	@Transactional
	public void deletar(Permissoes permissao) {
		permissao = buscarPorId(permissao.getId());
		gerenciador.remove(permissao);	
	}

}
