package com.algaWorks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaWorks.algafood.di.notificacao.Notificador;
import com.algaWorks.algafood.di.notificacao.NotificadorEmail;
import com.algaWorks.algafood.di.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
		return new AtivacaoClienteService(notificador);
	}

}
