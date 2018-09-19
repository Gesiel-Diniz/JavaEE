package br.com.exemplo.aula.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Ignore;
import org.junit.Test;
import br.com.exemplo.aula.domain.Cliente;
import br.com.exemplo.aula.domain.Pessoa;

public class ClienteDAOTeste {

	@Test
	@Ignore
	public void salvar() throws ParseException{
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		Cliente cliente = new Cliente();
		cliente.setDataDoCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("11/12/2016"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
	}
	
}
