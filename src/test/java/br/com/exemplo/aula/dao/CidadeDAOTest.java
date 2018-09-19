package br.com.exemplo.aula.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.exemplo.aula.domain.Cidade;
import br.com.exemplo.aula.domain.Estado;


public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Teste");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado){
			
			System.out.println(cidade.getCodigo()+" "+cidade.getNome()+" "+cidade.getEstado().getNome());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		Cidade cidade = cidadeDAO.buscar(2L);

		System.out.println(cidade.getCodigo()+" "+cidade.getNome()+" "+cidade.getEstado().getNome());

	}
	
	@Test
	@Ignore
	public void excluir(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(4L);
		
		if(cidade != null){
			cidadeDAO.excluir(cidade);
			System.out.println("Registro excluido com sucesso!");
		}else{
			System.out.println("Registro não encontrado!");
		}
		
	}
	
	@Test
	//@Ignore
	public void editar(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(3L);
		
		if(cidade != null){
			
			EstadoDAO estadoDAO = new EstadoDAO();
			Estado estado = estadoDAO.buscar(1L);
			
			if (estado != null) {

				cidade.setNome("Sumaré");
				cidade.setEstado(estado);

				cidadeDAO.editar(cidade);

				System.out.println("Registro editado com sucesso!");

			}else{
				
				System.out.println("Registro não pode ser editado!");
				
			}
			
		}else{
			
			System.out.println("Registro não encontrado!");
			
		}
		
	}

}
