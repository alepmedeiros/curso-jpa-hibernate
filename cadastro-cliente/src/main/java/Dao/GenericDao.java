package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.EntidadeBase;

public class GenericDao<T extends EntidadeBase> {
	
	public EntityManager getEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatejpa");
		return emf.createEntityManager();
	}
	
	public T salvar(T t) throws Exception {
		EntityManager em = getEm();
		try {
			em.getTransaction().begin();
			if (t.getId()==null) {
				em.persist(t);
			} else {
				if (!em.contains(t)) {
					if (em.find(t.getClass(), t.getId()) == null) {
						throw new Exception("Erro ao atualizar o registro!");
					}
				}
				t = em.merge(t);
			}
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
		return t;
		
	}
	
	public void remover(Class<T> clazz, Integer id) {
		EntityManager em = getEm();
		T t = em.find(clazz, id);  				
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	}
	
	public T consultarPorId(Class<T> clazz, Integer id) {
		EntityManager em = getEm();
		T t = null;
		try {
			t = em.find(clazz, id);
		}finally {
			em.close();
		}
		return t;
	}
	
	public List<T> consultarTodos(){
		EntityManager em = getEm();
		List<T> t;
		try {
			Query q = em.createNamedQuery("T.consultarTodos");
			t = q.getResultList();
		}catch (Exception e) {
			t = new ArrayList<>();
		}
		return t;
	}

}
