package com.algaWorks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)

//@Qualifier("urgente")
@Component
public class NotificadorSMS implements Notificador {
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS atraves do telefone: %s, %s\n",
				cliente.getNome(),cliente.getTelefone(), mensagem);
		}
	}

