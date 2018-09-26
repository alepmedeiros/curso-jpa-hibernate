package Dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import Utils.JPAUtils;

public class GenericDao<T> implements InterfaceDao<T> {

	private EntityManager em = JPAUtils.getEm();
	private Class<T> classe;
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
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
	}

}
