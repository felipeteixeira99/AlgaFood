package com.algaWorks.algafood.jpaEstado;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Estado;
import com.algaWorks.algafood.infrastructure.repository.EstadoImpl;



public class AlterarEstado {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoImpl estado = applicationContext.getBean(EstadoImpl.class);
		
		Estado estadoAlt = new Estado();
		estadoAlt.setId(1L);
		estadoAlt.setNome("Mato Grosso");
		
		estadoAlt = estado.adicionar(estadoAlt);
		
		System.out.println("Estado Alterado para: " + estadoAlt.getNome());
		
	}
//test
}
