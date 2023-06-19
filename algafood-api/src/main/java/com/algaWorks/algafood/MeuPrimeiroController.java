package com.algaWorks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaWorks.algafood.di.modelo.Cliente;
import com.algaWorks.algafood.di.service.AtivacaoClienteService;

@Controller //Anotacao do REST controller 
public class MeuPrimeiroController {
	
	private AtivacaoClienteService ativacaoClienteService;
	
	public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteservice) {
		this.ativacaoClienteService = ativacaoClienteservice;
		
		System.out.println("MeuPrimeiroControler: " + ativacaoClienteservice);
	}
	
	@GetMapping("/hello") //caminho 
	@ResponseBody //resposta
	public String hello() {
		
		Cliente joao = new Cliente("Joao", "joao.mail.com", "6599-9693");
		ativacaoClienteService.ativar(joao);
		
		return "Hello";
	}

}
