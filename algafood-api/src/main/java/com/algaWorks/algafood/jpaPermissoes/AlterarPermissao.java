package com.algaWorks.algafood.jpaPermissoes;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Permissoes;
import com.algaWorks.algafood.infrastructure.repository.PermissaoImpl;

public class AlterarPermissao {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoImpl permissao = applicationContext.getBean(PermissaoImpl.class);
		Permissoes permissao1 = new Permissoes();
		permissao1.setId(2l);
		permissao1.setNome("ADICIONAR_COZINHA");
		permissao1.setDescricao("Permite Adicionar Uma Cozinha");
		
		permissao.adcionar(permissao1);
		
		System.out.println("Permissao Alterada para " + permissao1.getNome());
	}
}
