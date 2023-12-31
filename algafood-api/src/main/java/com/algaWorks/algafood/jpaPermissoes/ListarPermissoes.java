package com.algaWorks.algafood.jpaPermissoes;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Permissoes;
import com.algaWorks.algafood.infrastructure.repository.PermissaoImpl;

public class ListarPermissoes {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoImpl permissao = applicationContext.getBean(PermissaoImpl.class);
		
		List<Permissoes> ListaDePermissoes = permissao.listar();
		
		for(Permissoes permissoes : ListaDePermissoes) {
			System.out.println("Permissoes Encontradas: " + permissoes.getNome());
		}
	}

}
