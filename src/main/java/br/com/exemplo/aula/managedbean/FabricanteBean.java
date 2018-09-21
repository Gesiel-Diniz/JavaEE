package br.com.exemplo.aula.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.exemplo.aula.dao.FabricanteDAO;
import br.com.exemplo.aula.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable{

	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo(){
		fabricante = new Fabricante();
	}
	
	@PostConstruct
	public void listar(){
		
		try{
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
			
		}catch(RuntimeException erro){
			
			Messages.addGlobalError("Houve um erro ao listar os fabricantes, por favor tente novamente.");
			erro.printStackTrace();
			
		}
		
	}
	
	public void salvar(){
		
		try{
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);
			
			novo();
			fabricantes = fabricanteDAO.listar();
			
			Messages.addGlobalInfo("Fabricante salvo com sucesso!");
			
		}catch(RuntimeException erro){
			
			Messages.addGlobalError("Houve um erro ao salvar o fabricante, por favor tente novamente.");
			erro.printStackTrace();
			
		}
		
	}
	
	
	public void editar(ActionEvent evento){
		
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		
	}	
	
	public void excluir(ActionEvent evento){
		
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		try{
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			
			fabricantes = fabricanteDAO.listar();
			
			Messages.addGlobalInfo("Fabricante excluido com sucesso!");
		
		}catch(RuntimeException erro){
			Messages.addGlobalError("Houve um erro ao tentar excluir o fabricante, por favor tente novamente.");
			erro.printStackTrace();
		}
		
	}
	
}
