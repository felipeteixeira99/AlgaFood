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
import com.algaWorks.algafood.domain.model.Estado;


public class AdicionarCidade {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		CidadeImpl cidade = applicationContext.getBean(CidadeImpl.class);
		Cidade cidade1 = new Cidade();
		Estado estado1 = new Estado();
		estado1.setId(1L);
		
		cidade1.setNome("Catalao");
		cidade1.setEstado(estado1);
		
		cidade.adicionar(cidade1);
		
		System.out.println("Cidade Adicionada: " + cidade1.getNome());
	}
}
