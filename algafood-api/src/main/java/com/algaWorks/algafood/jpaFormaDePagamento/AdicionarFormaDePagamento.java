package com.algaWorks.algafood.jpaFormaDePagamento;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaWorks.algafood.AlgafoodApiApplication;
import com.algaWorks.algafood.domain.model.FormaDePagamento;
import com.algaWorks.algafood.infrastructure.repository.FormaDePagamentoImpl;

public class AdicionarFormaDePagamento {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaDePagamentoImpl formaPagamento = applicationContext.getBean(FormaDePagamentoImpl.class);
		
		FormaDePagamento formaDePagamento = formaPagamento.buscarPorId(4L);
		
		System.out.println(formaDePagamento.getNome());
		
	}
}
