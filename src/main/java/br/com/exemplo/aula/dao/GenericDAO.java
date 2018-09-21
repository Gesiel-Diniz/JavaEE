package br.com.exemplo.aula.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.exemplo.aula.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade enti){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transa = null;
		
		try{
			
			transa = sessao.beginTransaction();
			sessao.save(enti);
			transa.commit();
			
		}catch(RuntimeException erro){
			
			if(transa != null){
				transa.rollback();
			}
			
			throw erro;
			
		}finally {
		
			sessao.close();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			sessao.close();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			sessao.close();
		}
		
	}
	
	
	public void excluir(Entidade enti){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transa = null;
		
		try{
			
			transa = sessao.beginTransaction();
			sessao.delete(enti);
			transa.commit();
			
		}catch(RuntimeException erro){
			
			if(transa != null){
				transa.rollback();
			}
			
			throw erro;
			
		}finally {
		
			sessao.close();
			
		}
		
	}
	
	public void editar(Entidade enti){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transa = null;
		
		try{
			
			transa = sessao.beginTransaction();
			sessao.update(enti);
			transa.commit();
			
		}catch(RuntimeException erro){
			
			if(transa != null){
				transa.rollback();
			}
			
			throw erro;
			
		}finally {
		
			sessao.close();
			
		}
		
	}
	
	public void merge(Entidade enti){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transa = null;
		
		try{
			
			System.out.println(enti.toString());
			
			transa = sessao.beginTransaction();
			sessao.merge(enti);
			transa.commit();
			
		}catch(RuntimeException erro){
			
			if(transa != null){
				transa.rollback();
			}
			
			throw erro;
			
		}finally {
			sessao.close();
		}
		
	}

}
