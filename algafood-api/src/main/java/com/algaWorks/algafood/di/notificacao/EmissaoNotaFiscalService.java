package com.algaWorks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;
import com.algaWorks.algafood.di.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService{
	
		@EventListener
		public void clienteAtivadoListener(ClienteAtivadoEvent event) {
			System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
			//System.out.println("Cliente " + event.getCliente().getNome() + " agora está ativo.");
			
		}
	
	}
