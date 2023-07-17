package com.algaWorks.algafood.jpaRestaurante;



import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Restaurante;
import com.algaWorks.algafood.infrastructure.repository.RestauranterepositoryImpl;

public class ExclusaoRestaurante {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranterepositoryImpl restauranteRepository = applicationContext.getBean(RestauranterepositoryImpl.class);
		
		
		
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		

		restauranteRepository.deletar(restaurante);
				
	}
}
