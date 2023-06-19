package com.algaWorks.algafood.di.notificacao;

import com.algaWorks.algafood.di.modelo.Cliente;

public interface Notificador {
	
	void notificar(Cliente cliente, String mensagem);

}
