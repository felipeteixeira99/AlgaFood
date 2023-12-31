package com.algaWorks.algafood.jpaFormaDePagamento;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.FormaDePagamento;
import com.algaWorks.algafood.infrastructure.repository.FormaDePagamentoImpl;

public class AlterarFormaDePagamento {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaDePagamentoImpl formaPagamento = applicationContext.getBean(FormaDePagamentoImpl.class);
		
		FormaDePagamento forma1 = new FormaDePagamento();
		forma1.setId(1L);
		forma1.setNome("Cartão de Credito");
		
		forma1 = formaPagamento.adicionar(forma1);
		
		System.out.println("Forma de Pagamento Alterada de com sucesso: " + forma1.getNome());
	}
}
