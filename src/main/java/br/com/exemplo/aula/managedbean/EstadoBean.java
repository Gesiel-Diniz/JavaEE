package br.com.exemplo.aula.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class EstadoBean {
	
	public void salvar(){
		
		String msg = "Programação Web com Java";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, message);
		
		
		
		//System.out.println("Programação Web com Java");
		
	}

}
