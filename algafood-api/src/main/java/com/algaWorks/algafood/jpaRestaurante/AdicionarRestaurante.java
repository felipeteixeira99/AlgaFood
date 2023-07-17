package com.algaWorks.algafood.jpaRestaurante;



import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.Restaurante;
import com.algaWorks.algafood.infrastructure.repository.RestauranterepositoryImpl;

public class AdicionarRestaurante {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranterepositoryImpl restauranteRepository = applicationContext.getBean(RestauranterepositoryImpl.class);
		
//		Restaurante restaurante = restauranteRepository.adicionar(Restaurante.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("MC Donalds");
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("SubWay");
		
		restaurante1 = restauranteRepository.adicionar(restaurante1);
		restaurante2 = restauranteRepository.adicionar(restaurante2);
		
		System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
		
	}
}
