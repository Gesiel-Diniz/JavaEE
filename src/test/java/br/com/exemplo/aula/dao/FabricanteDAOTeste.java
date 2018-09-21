package br.com.exemplo.aula.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.exemplo.aula.domain.Fabricante;

public class FabricanteDAOTeste {

	
	@Test
	@Ignore
	public void salvar(){
		
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Teste");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		for(Fabricante fabricante: resultado){
			System.out.println(fabricante.getCodigo()+"  "+fabricante.getDescricao() );
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante != null){
			System.out.println(fabricante.getCodigo()+"  "+fabricante.getDescricao() );
		}else{
			System.out.println("Registro não encontrado");
		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 4L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante != null){
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro excluido com sucesso!");
		}else{
			System.out.println("Registro não encontrado");
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante != null) {
			fabricante.setDescricao("Néo Química");
			fabricanteDAO.editar(fabricante);
		}else{
			System.out.println("Registro não encontrado");
		}
		
	}
	
	
	@Test
	@Ignore
	public void mergeIncluir(){
		
		//Fabricante fabricante = new Fabricante();
		//fabricante.setDescricao("CIMED");
		//FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//fabricanteDAO.merge(fabricante);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("CIMED");
		fabricanteDAO.merge(fabricante);
		
	}
	
	
}
