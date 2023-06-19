package com.algaWorks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;
import com.algaWorks.algafood.di.notificacao.Notificador;
import com.algaWorks.algafood.di.notificacao.NotificadorEmail;



public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
		
		System.out.println("AtivacaoClienteService " + notificador);
	}


	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente,"Seu cadastro no sistema está ativo");
	}
	
}
