package com.algaWorks.algafood.jpaCozinha;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.infrastructure.repository.CozinhaImpl;


public class AdicionarCozinha {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaImpl cozinha = applicationContext.getBean(CozinhaImpl.class);	
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Americana");
		cozinha.adicionar(cozinha1);
	
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Arabe");
		cozinha.adicionar(cozinha2);
		
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
		
		}
	}
