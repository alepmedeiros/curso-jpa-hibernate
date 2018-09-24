package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utils.JPAUtils;

public class GenericDao<T> implements InterfaceDao<T> {
	
	private EntityManager em = JPAUtils.getEm();
	
	@Override
	public void save(T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}		
	}

	@Override
	public T getList(Class<T> clazz,Serializable id) {
		T t = null;
		try {
			t = em.find(clazz, id);
		} finally {
			em.close();
		}
		return t;
	}

	@Override
	public void update(T t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(T t) {
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public List<T> list() {
		List<T> t = null;
		try {
			Query q = em.createNamedQuery("T.list");
			t = q.getResultList();
		} catch (Exception e) {
			t = new ArrayList<T>();
		}finally {
			em.close();
		}
		return t;
	}
}
