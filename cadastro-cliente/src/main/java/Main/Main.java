package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Pessoa;

public class Main {
	
	public static void main(String[] args) {
		
		
		//CRUD
		//Persistindo os dados
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Aline");
		
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Insert : " + e.getMessage());
		}finally {
			em.close();
		}
		
	}
	
}
