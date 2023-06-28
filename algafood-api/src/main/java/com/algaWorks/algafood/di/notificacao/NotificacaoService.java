package com.algaWorks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {
	
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro está ativo");
		//System.out.println("Cliente " + event.getCliente().getNome() + " agora está ativo.");
		
	}

}
