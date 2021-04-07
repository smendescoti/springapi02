package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.adapters.DTOEntityAdapter;
import br.com.cotiinformatica.dtos.TarefaPostDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.services.TarefaService;
import br.com.cotiinformatica.validations.TarefaPostValidation;

@Controller
public class TarefaPostController {

	@Autowired
	private TarefaService service;

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<String>> post(@RequestBody TarefaPostDTO dto) {
		
		List<String> result = new ArrayList<String>();
		
		try {
			
			TarefaPostValidation validation = new TarefaPostValidation();
			result = validation.validate(dto); //validando o objeto DTO..
			
			//verificando se ocorreram erros de validação..
			if(result.size() > 0) {
				
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(result);				
			}
			else {
				
				//transferir os dados do DTO para um objeto da entidade Tarefa..
				Tarefa tarefa = DTOEntityAdapter.getTarefa(dto);
				
				//gravando no banco de dados
				service.saveOrUpdate(tarefa);
				
				result.add("Tarefa cadastrada com sucesso.");
				
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(result);
			}
		}
		catch(Exception e) {
			
			result.add("Erro: " + e.getMessage());
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result);			
		}
	}

}











