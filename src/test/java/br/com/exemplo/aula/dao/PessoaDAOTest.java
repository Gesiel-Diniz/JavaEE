package br.com.exemplo.aula.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.exemplo.aula.domain.Cidade;
import br.com.exemplo.aula.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(1L);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Gesiel Diniz da Silva");
		pessoa.setCpf("22559876754");
		pessoa.setRg("304483137");
		pessoa.setEmail("gesie@dmail.com");
		pessoa.setTelefone("(19)32616012");
		pessoa.setCelular("(19)987529565");
		pessoa.setBairro("Colinas das Nascentes");
		pessoa.setRua("Rua Rio Jacarézinho");
		pessoa.setCidade(cidade);
		pessoa.setCep("13058-679");
		pessoa.setNumero("20");
		pessoa.setComplemento("Fundos");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		pessoaDAO.salvar(pessoa);

	}
	
	@Test
	@Ignore
	public void listar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		
		for(Pessoa pessoa: resultado){
			
			System.out.println(pessoa.getCodigo()+" "+pessoa.getNome()+" "+pessoa.getCidade().getNome());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		System.out.println(pessoa.getCodigo()+" "+pessoa.getNome()+" "+pessoa.getCidade().getNome());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		if(pessoa != null){
			pessoaDAO.excluir(pessoa);
			System.out.println("Pessoa excluida com sucesso!");
		}else{
			System.out.println("Pessoa não pode ser excluida!");
		}

	}
	
	@Test
	@Ignore
	public void editar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		if(pessoa != null){
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			Cidade cidade = cidadeDAO.buscar(2L);
			
			pessoa.setNome("Gesiel Diniz");
			
			if(cidade != null){
				pessoa.setCidade(cidade);
			}
			
			pessoaDAO.editar(pessoa);
			System.out.println("Pessoa editada com sucesso!");
		}else{
			System.out.println("Pessoa não pode ser editada!");
		}
		
	}
	
}
