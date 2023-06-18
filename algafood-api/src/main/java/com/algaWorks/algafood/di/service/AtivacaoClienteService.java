package com.algaWorks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;
import com.algaWorks.algafood.di.notificacao.NotificadorEmail;

@Component
public class AtivacaoClienteService {
	
	private NotificadorEmail notificador;
	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente,"Seu cadastro no sistema está ativo");
	}
	
}
