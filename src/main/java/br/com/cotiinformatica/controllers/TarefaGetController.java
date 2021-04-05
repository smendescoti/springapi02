package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TarefaGetController {

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<String>> getAll() {
		return null;
	}

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<String>> getById(@PathVariable("id") Integer id) {
		return null;
	}

}
