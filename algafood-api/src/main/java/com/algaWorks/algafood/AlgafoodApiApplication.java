package com.algaWorks.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgafoodApiApplication {

	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++) {
			System.out.println("Parametro N - " + i +  ": " + args[i]);
		}
		SpringApplication.run(AlgafoodApiApplication.class, args);
	}

}
