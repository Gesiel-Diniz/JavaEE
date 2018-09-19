package br.com.exemplo.aula.dao;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.exemplo.aula.domain.Fabricante;
import br.com.exemplo.aula.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar(){
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(3L);
		
		if (fabricante != null) {

			Produto produto = new Produto();
			produto.setDescricao("Teste 30mg");
			produto.setFabricante(fabricante);
			produto.setPreco(new BigDecimal("15.90"));
			produto.setQuantidade(new Short("3"));
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
			
			System.out.println("Produto cadastrado com sucesso!");

		}else{
			System.out.println("Produto não pode ser cadastrado!");
		}
		
	}
	
	@Test
	@Ignore
	public void listar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		for(Produto produto: resultado){
			
			System.out.println(produto.getCodigo()+" "+produto.getDescricao()+" "+produto.getQuantidade()+" "+produto.getPreco()+" "+produto.getFabricante().getDescricao());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		
		System.out.println(produto.getCodigo()+" "+produto.getDescricao()+" "+produto.getQuantidade()+" "+produto.getPreco()+" "+produto.getFabricante().getDescricao());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(3L);
		
		if(produto != null){
			
			produtoDAO.excluir(produto);
			System.out.println("Produto excluido com sucesso!");

		}else{
			
			System.out.println("Produto não pode ser excluido!");
			
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(5L);
		
		if(produto != null){
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			Fabricante fabricante = fabricanteDAO.buscar(1L);
			
			produto.setFabricante(fabricante);
			produto.setDescricao("Dipirona 150mg");
			produto.setPreco(new BigDecimal("12.90"));
			produto.setQuantidade(new Short("34"));

			produtoDAO.editar(produto);
			
			System.out.println("Produto editado com sucesso!");
			
		}else{
			
			System.out.println("Produto não pode ser editado!");
			
		}
		
	}
	
}
