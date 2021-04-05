package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TarefaPutController {

	@CrossOrigin
	@RequestMapping(value = "/api/tarefas", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<String>> put() {
		return null;
	}

}
