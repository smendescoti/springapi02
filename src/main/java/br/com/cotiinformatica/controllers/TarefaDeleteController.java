package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.services.TarefaService;

@Controller
public class TarefaDeleteController {

	@Autowired
	private TarefaService service;
	
	@CrossOrigin
	@RequestMapping(value = "/api/tarefas/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<List<String>> delete(@PathVariable("id") Integer id) {

		List<String> result = new ArrayList<String>();
		
		try {
			
			//buscar a tarefa no repositorio pelo id
			Tarefa tarefa = service.findById(id);
			
			//excluindo a tarefa
			service.delete(tarefa);
			
			result.add("Tarefa excluída com sucesso.");
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(result);			
		}
		catch(Exception e) {
			
			result.add("Erro: " + e.getMessage());
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result);			
		}		
	}
}
