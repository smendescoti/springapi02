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

import br.com.cotiinformatica.dtos.LoginPostDTO;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.services.UsuarioService;
import br.com.cotiinformatica.validations.LoginPostValidation;

@Controller
public class LoginPostController {

	@Autowired
	private UsuarioService service;

	@CrossOrigin
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<String>> post(@RequestBody LoginPostDTO dto) {

		List<String> result = new ArrayList<String>();

		try {

			LoginPostValidation validation = new LoginPostValidation();
			result = validation.validate(dto);

			// verificar se houveram erros de validação
			if (result.size() > 0) {

				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(result);			
				
			} else {

				// buscar o usuario no banco de dados atraves do email e da senha..
				Usuario usuario = service.find(dto.getEmail(), dto.getSenha());

				// verificar se o usuario foi encontrado..
				if (usuario != null) {

					result.add("Usuário autenticado com sucesso.");

					return ResponseEntity.status(HttpStatus.OK).body(result);

				} else {

					result.add("Acesso negado. Usuário inválido.");

					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
				}
			}
		} catch (Exception e) {

			result.add("Erro: " + e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
}
