package Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import Utils.JPAUtils;

public class GenericDao<T> implements InterfaceDao<T> {

	private EntityManager em = JPAUtils.getEm();
	private Class<T> classe;
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}	
	}

	@Override
	public void atualizar(T t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} 
	}

	@Override
	public void apagar(Serializable id) {
		try {
			em.getTransaction().begin();
			T t = em.find(classe, id);
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public T buscarPorId(Serializable id) {
		return em.find(classe, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		return em.createQuery("FROM " + classe.getName()).getResultList();
	}

	@Override
	public void fechar() {
		em.close();	
	}

	
	
	/*@Override
	public void salve(T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();	
		}  finally {
			em.close();
		}		
	}

	@Override
	public void update(Serializable id) {
		T t = em.find(classe, id);
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Serializable id) {
		T t = em.find(classe, id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();	
		} finally {
			em.close();
		}
	}

	@Override
	public T select(Serializable id) {
		T t = null;
		try {
			t = em.find(classe, id);	
		} finally {
			em.close();
		}		
		return t;
	}*/

}
