package br.com.exemplo.aula.dao;

import org.junit.Test;

import br.com.exemplo.aula.domain.Pessoa;
import br.com.exemplo.aula.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	public void salvar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		if(pessoa != null){
			
			Usuario usuario = new Usuario();
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenha("87rergvnl45nwelfn34");
			usuario.setTipo('A');
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);
			
			System.out.println("Usuario cadastrado com sucesso!");
			
		}else{
			System.out.println("Usuario não foi cadastrado!");
		}
		
	}

}
