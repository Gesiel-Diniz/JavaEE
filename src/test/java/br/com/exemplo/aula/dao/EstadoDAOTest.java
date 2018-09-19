package br.com.exemplo.aula.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.exemplo.aula.domain.Estado;


public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar(){
		
		Estado estado = new Estado();
		estado.setNome("Minas Gerais");
		estado.setSigla("MG");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado: resultado){
			System.out.println(estado.getSigla()+"  "+estado.getNome());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado != null){
			System.out.println(estado.getCodigo()+"  "+estado.getSigla()+"  "+estado.getNome());
		}else{
			System.out.println("Registro não encontrado");
		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado != null){
			estadoDAO.excluir(estado);
			System.out.println("Registro excluido com sucesso!");
		}else{
			System.out.println("Registro não encontrado");
		}
		
	}
	
	@Test
	public void editar(){
		
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado != null) {
			estado.setNome("Santa Catarina");
			estadoDAO.editar(estado);
		}else{
			System.out.println("Registro não encontrado");
		}
		
		
		
	}
	
}
