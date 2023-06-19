package com.algaWorks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaWorks.algafood.di.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {
	
		@Bean
		public  NotificadorEmail notificadorEmail() {
			NotificadorEmail notificador = new NotificadorEmail("smtp.algagmail.com.br");
			notificador.setCaixaAlta(true);
			return notificador;
		}
		
	}

