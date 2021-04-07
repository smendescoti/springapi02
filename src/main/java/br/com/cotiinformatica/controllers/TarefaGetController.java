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

import br.com.cotiinformatica.adapters.EntityDTOAdapter;
import br.com.cotiinformatica.dtos.TarefaGetDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.services.TarefaService;

@Controller
public class TarefaGetController {

	@Autowired
	private TarefaService service;

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas/{idUsuario}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TarefaGetDTO>> getByUsuario(@PathVariable("idUsuario") Integer idUsuario) {

		List<TarefaGetDTO> result = new ArrayList<TarefaGetDTO>();

		try {
			
			//realizando a consulta de tarefas por usuario..
			List<Tarefa> tarefas = service.findByUsuario(idUsuario);
			
			//transferir os registros de Tarefa para a lista de TarefaGetDTO
			for(Tarefa item : tarefas) {
				result.add(EntityDTOAdapter.getTarefa(item));
			}
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(result);
		}
		catch(Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result);			
		}
	}
}
