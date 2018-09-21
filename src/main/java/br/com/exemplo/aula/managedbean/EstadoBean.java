package br.com.exemplo.aula.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import br.com.exemplo.aula.dao.EstadoDAO;
import br.com.exemplo.aula.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	
	private Estado estado;
	private List<Estado> estados;
	
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public void novo(){
		estado = new Estado();
	}
	
	public void editar(ActionEvent evento){
		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}	
	
	
	public void excluir(ActionEvent evento){
		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		try{
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado excluido com sucesso!");
		
		}catch(RuntimeException erro){
			Messages.addGlobalError("Houve um erro ao tentar excluir o estado, por favor tente novamente.");
			erro.printStackTrace();
		}
		
	}
	
	@PostConstruct
	public void listar(){
		
		try{
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();	
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Houve um erro ao tentar listarvos estados, por favor tente novamente.");
			erro.printStackTrace();
		}
		
	}


	public void salvar(){
		
		try{
		
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			
			novo();
			estados = estadoDAO.listar();	
	
			Messages.addGlobalInfo("Estado salvo com sucesso!");

		}catch(RuntimeException erro){
			
			Messages.addGlobalError("Houve um erro ao salvar o estado, por favor tente novamente.");
			erro.printStackTrace();
			
		}
	
	}

}
