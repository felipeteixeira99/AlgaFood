package com.algaWorks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaWorks.algafood.domain.model.Cozinha;
import com.algaWorks.algafood.domain.model.CozinhasXmlWrapper;
import com.algaWorks.algafood.domain.repository.CozinhaRepository;

//Modelagem Rest API
//Essa classe serve para que todas as requisições com a URI /cozinhas caiam nesse controlador


//@Controller //Componente spring do tipo controlador
//@ResponseBody //
@RestController //Possui o Controller e o ResponseBody
@RequestMapping(value = "/cozinhas")//, produces = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(value = "/cozinhas", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//Mapeamento do controlador responsavel pelas as requisições especificando a URI desse controlador
//colocando o produces na classe, ele vai pegar todo o escopo da classe
public class CozinhaController {
	
	@Autowired  
	private CozinhaRepository cozinhaRepository; //variavel de instancia que implementa a interface de Cozinha
		
	//Metodo que irá retornar e json
	@GetMapping//Significa que requisições com o verbo HTTP Get irão cair nesse metodo
	public List<Cozinha> listarCozinhasJson(){  //metodo que recebe e retorna a listagem de cozinhas salvas no banco
		return cozinhaRepository.buscarTodos();
	}
	
	//Metodo que traz as cozinhas salvas no banco, porem usando uma outra classe que embrulha as cozinhas em formato XML 
	//Customizado
	 @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	 public CozinhasXmlWrapper listarXml(){
		 return new CozinhasXmlWrapper(cozinhaRepository.buscarTodos());
	}
	 
	/*
	 * //Metodo que irá retornar em JSON
	 * 
	 * @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //Significa que
	 * requisições com o verbo HTTP Get irão cair nesse metodo public List<Cozinha>
	 * listarCozinhaJson(){ //metodo que recebe e retorna a listagem de cozinhas
	 * salvas no banco return cozinhaRepository.buscarTodos(); }
	 */
	
	//Retorna uma cozinha conforme ID passado no parametro
	//A anotação pathvariable atribui a variavel passada no getmapping para o id, e o mesmo é retornado no fim do metodo
	
	//@ResponseStatus(HttpStatus.CREATED) //Alterar a resposta HTTP
//	@GetMapping("/{cozinhaId}")
//	public Cozinha buscarCozinhaId(@PathVariable Long cozinhaId) {
//		return cozinhaRepository.buscarPorId(cozinhaId);
//	}
	 
	 	//Customizando a resposta http e solicitando que ela retorne um corpo da resposta do tipo cozinha
		@GetMapping("/{cozinhaId}")
		public ResponseEntity <Cozinha> buscarCozinhaId(@PathVariable Long cozinhaId) {
			Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId);
			
			if (cozinha != null) {
				return ResponseEntity.ok(cozinha);
			}
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.notFound().build(); //faz a mesma coisa que o codigo acima. com menos codigo
			
//			return ResponseEntity.status(HttpStatus.OK).body(cozinha); //Retorna a resposta HTTP com um corpo
//			return ResponseEntity.status(HttpStatus.OK).build(); //Retorna uma resposta HTTp, porem sem um corpo
//			return ResponseEntity.ok(cozinha);  //Mesma coisa da linha acima, porem com menos codigo
/*			
			//Esse bloco faz com que a requisição seja redirecionada para outro local - codigo de status 302
			//Faz a mesma coisa que o codigo de cima, porem sem o redirecionamento
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.LOCATION, "http://api.algafood.local:8080/cozinhas");
			return ResponseEntity
					.status(HttpStatus.FOUND)
//					.headers(headers)
//					.body(cozinha); //retorna o corpo da resposta
					//.build(); //retorna sem o corpo da resposta
		}
		*/
		}
		
		// Inclusão de Cozinha - Metodo POST
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED) //retorna o codigo http 201 Que significa que o recurso foi criado
		public void adicionar(@RequestBody Cozinha cozinha) {
			cozinhaRepository.adicionar(cozinha);
		}
		
		
		//Metodo de Update PUT
		
		@PutMapping("/{cozinhaId}")
		public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
				@RequestBody Cozinha cozinha){  //Cozinha que o consumidor da API está tentando enviar ao banco
			Cozinha cozinhaAtual = cozinhaRepository.buscarPorId(cozinhaId); //Nova cozinha que será salva dentro do banco
			
			if(cozinha != null) {
				BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); //Copie os valores de cozinha e atribua a cozinhAtual
				cozinhaRepository.adicionar(cozinhaAtual);
				
				return ResponseEntity.ok(cozinhaAtual);
			}
			return ResponseEntity.notFound().build();
		}
		
		//Anotacao
		@DeleteMapping("/{cozinhaId}") //Metodo para deletar um recurso
		public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
			//Esse try é para tratar caso a cozinha a ser deletada esteja sendo referenciada em alguma outra tabela
			//Nesse caso ele não irá permitir a sua exclusao
			try {
				Cozinha cozinha = cozinhaRepository.buscarPorId(cozinhaId); //Nova cozinha que será salva dentro do banco
				if(cozinha != null) {
					cozinhaRepository.deletar(cozinha);
					return ResponseEntity.noContent().build();	//Se cozinha for diferente de null deleta o ID passado no parametro
			}
				return ResponseEntity.notFound().build(); //Caso contrario retorne Notfound -Recurso não encontrado
			
			}catch(DataIntegrityViolationException e){
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}		

