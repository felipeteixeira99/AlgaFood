package com.algaWorks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Anotacao do REST controller 
public class MeuPrimeiroController {
	
	@GetMapping("/hello") //caminho 
	@ResponseBody //resposta
	public String hello() {
		return "Hello Word";
	}

}
