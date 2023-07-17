package com.algaWorks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafoof.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		List <Cozinha> cozinhas = cozinhaRepository.listar();
		
		for(Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNome());
		}
	}
}
