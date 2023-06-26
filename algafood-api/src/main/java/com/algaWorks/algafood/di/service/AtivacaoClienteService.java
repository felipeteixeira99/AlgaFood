package com.algaWorks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;
import com.algaWorks.algafood.di.notificacao.NivelUrgencia;
import com.algaWorks.algafood.di.notificacao.Notificador;
import com.algaWorks.algafood.di.notificacao.NotificadorEmail;
import com.algaWorks.algafood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
	
	//@Qualifier("urgente")
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired
	private Notificador notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if(notificador != null) {
			notificador.notificar(cliente,"Seu cadastro no sistema está ativo");
		} else {
			System.out.println("Não existe notificador, mas o cliente foi ativado");
		}
	}		
}
