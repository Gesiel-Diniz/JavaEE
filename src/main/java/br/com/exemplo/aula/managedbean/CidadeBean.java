package br.com.exemplo.aula.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import br.com.exemplo.aula.dao.CidadeDAO;
import br.com.exemplo.aula.dao.EstadoDAO;
import br.com.exemplo.aula.domain.Cidade;
import br.com.exemplo.aula.domain.Estado;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable{

	private Cidade cidade;
	private List<Estado> estados;
	private List<Cidade> cidades;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
	
	public void salvar(){
		
		try{
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			
			System.out.println(cidade);
			
			cidadeDAO.merge(cidade);
			
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			cidades = cidadeDAO.listar();
			
			Messages.addGlobalInfo("Cidade salva com sucesso!");
			
		}catch(RuntimeException erro){
			
			Messages.addGlobalError("Houve um erro ao salvar a cidade, por favor tente novamente.");
			erro.printStackTrace();
			
		}
		
	}
	

	public void novo(){
		
		cidade = new Cidade(); 
		
		try {
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um erro ao listar os estados, por favor tente novamente.");
			erro.printStackTrace();
		}
	
	}
	
	
	@PostConstruct
	public void listar(){
		
		try {
			
			CidadeDAO  cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (RuntimeException erro) {
			
			Messages.addGlobalError("Houve um erro ao listar as cidades, por favor tente novamente.");
			erro.printStackTrace();
			
		}
		
	}
	
	
}
