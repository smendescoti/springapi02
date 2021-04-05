package br.com.cotiinformatica.adapters;

import br.com.cotiinformatica.dtos.UsuarioPostDTO;
import br.com.cotiinformatica.entities.Usuario;

public class DTOEntityAdapter {

	//método para converter um UsuarioPostDTO para Usuario
	public static Usuario getUsuario(UsuarioPostDTO dto) {
		
		Usuario usuario = new Usuario(); //entidade
		
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		
		return usuario;
	}
	
}
