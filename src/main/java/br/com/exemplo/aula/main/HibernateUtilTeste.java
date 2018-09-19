package br.com.exemplo.aula.main;

import org.hibernate.Session;

import br.com.exemplo.aula.util.HibernateUtil;

public class HibernateUtilTeste {
	
	public static void main(String[] args){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

}
