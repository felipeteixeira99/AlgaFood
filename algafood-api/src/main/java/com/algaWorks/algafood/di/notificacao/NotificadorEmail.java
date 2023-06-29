package com.algaWorks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaWorks.algafood.di.modelo.Cliente;


//@Profile("prod")
//@Qualifier("normal")
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmail implements Notificador {
	
	@Value("${notificador.emai.host-servidor}")
	private String host;
	
	@Value("${notificador.email.porta-servidor}")
	private int porta;
	
//	public NotificadorEmail() {
//		System.out.println("Notificador Email Real");
//	}
	
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host " + host);
		System.out.println("Porta " + porta);
		System.out.printf("Notificando %s através do e-mail %s: %s\n",
				cliente.getNome(),cliente.getEmail(), mensagem);
		}
	
	
	
	}
