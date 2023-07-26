package com.algaWorks.algafood.jpaCidade;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Cidade;
import com.algaWorks.algafood.infrastructure.repository.CidadeImpl;
import com.algaWorks.algafood.infrastructure.repository.EstadoImpl;


public class BuscarPorId {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		CidadeImpl cidade = applicationContext.getBean(CidadeImpl.class);
		Cidade cidadeId = cidade.buscarPorId(2L);
		
		System.out.println("Cidade Encontrada: " + cidadeId.getNome());
	}
}
