package com.algaWorks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;
import com.algaWorks.algafood.di.notificacao.Notificador;
import com.algaWorks.algafood.di.notificacao.NotificadorEmail;

@Component
public class AtivacaoClienteService {
	
	@Autowired
	private Notificador notificador;
	
//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}
//	
//	public AtivacaoClienteService(String qualquer) {
//		
//	}


	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente,"Seu cadastro no sistema está ativo");
	}

	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}
		
}
