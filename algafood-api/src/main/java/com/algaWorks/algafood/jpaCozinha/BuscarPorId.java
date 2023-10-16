package com.algaWorks.algafood.jpaCozinha;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.infrastructure.repository.CozinhaImpl;


public class BuscarPorId {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaImpl cozinha = applicationContext.getBean(CozinhaImpl.class);	
		
		Cozinha cozinhaEncontrada = cozinha.buscarPorId(4L);
		
		System.out.println(cozinhaEncontrada.getNome());
		
		}
	}
