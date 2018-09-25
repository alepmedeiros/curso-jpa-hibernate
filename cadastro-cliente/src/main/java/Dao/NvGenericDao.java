package Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import utils.JPAUtils;

public class NvGenericDao<T> implements NvInterfaceDao<T>{

	private EntityManager em = JPAUtils.getEm();
	private Class<T> classe;
	
	public NvGenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public void adicionar(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void remover(T t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void atualizar(Serializable id) {
		T t = em.find(classe, id);
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public List<T> pesquisarPorId(Serializable id) {
		String sql = "select e from " + classe.getName() + 
					" where id = :id ";
		TypedQuery<T> qry = em.createQuery(sql, classe);
		List<T> lista = qry.getResultList();
		return lista;
	}
	
	@Override
	public List<T> pesquisarPorNome(String nome) {
		String sql = "select e from " + classe.getName() + 
				" where id = :nome ";
		TypedQuery<T> qry = em.createQuery(sql, classe);
		List<T> lista = qry.getResultList();
		return lista;
	}

	@Override
	public List<T> pesquisarTodos() {
		String sql = "select e from " + classe.getName();
		TypedQuery<T> qry = em.createQuery(sql, classe);
		List<T> lista = qry.getResultList();
		return lista;
	}
	
	@Override
	public void close() {
		em.close();
	}
}
