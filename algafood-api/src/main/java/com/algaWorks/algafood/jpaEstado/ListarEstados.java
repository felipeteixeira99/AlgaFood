package com.algaWorks.algafood.jpaEstado;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Estado;
import com.algaWorks.algafood.infrastructure.repository.EstadoImpl;



public class ListarEstados {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoImpl estado = applicationContext.getBean(EstadoImpl.class);
		
		List<Estado> ListaDeEstados = estado.listarTodos();
		
		for(Estado estados : ListaDeEstados) {
			System.out.println(estados.getNome());
		}	
	}

}
