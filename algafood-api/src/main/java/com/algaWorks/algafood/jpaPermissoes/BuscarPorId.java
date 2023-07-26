package com.algaWorks.algafood.jpaPermissoes;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Permissoes;
import com.algaWorks.algafood.infrastructure.repository.PermissaoImpl;

public class BuscarPorId {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoImpl permissao = applicationContext.getBean(PermissaoImpl.class);
		Permissoes permissaoId = new Permissoes();
		permissaoId = permissao.buscarPorId(2l);
		System.out.println("Permissao Selecionada: " + permissaoId.getNome());
	}
}
