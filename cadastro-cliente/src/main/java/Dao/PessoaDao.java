package Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Pessoa;

public class PessoaDao implements InterfaceDao<Pessoa>{

	public EntityManager getEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatejpa");
		return emf.createEntityManager();
	}
	
	private EntityManager em = getEm();
	
	@Override
	public void save(Pessoa pessoa){		
		try {
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}		
	}

	@Override
	public Pessoa getList(Serializable id) {
		Pessoa pessoa = null;
		try {
			pessoa = em.find(Pessoa.class, id);
		} finally {
			em.close();
		}
		return pessoa;
	}

	@Override
	public void update(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.merge(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.remove(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Pessoa> list() {
		List<Pessoa> lista = null;
		lista = em.createQuery("from Pessoa").getResultList();
		return lista;
	}

}
