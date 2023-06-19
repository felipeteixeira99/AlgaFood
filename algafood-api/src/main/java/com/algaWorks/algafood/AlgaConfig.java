package com.algaWorks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaWorks.algafood.di.notificacao.NotificadorEmail;
import com.algaWorks.algafood.di.service.AtivacaoClienteService;

//@Configuration
public class AlgaConfig {
	
	@Bean
	public  NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algagmail.com.br");
		notificador.setCaixaAlta(true);
		return notificador;
	}
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificadorEmail());
	}

}
