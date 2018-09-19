package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Pessoa;

public class PessoaDao {

	public EntityManager getEm() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatejpa");
		return emf.createEntityManager();
	}
	
	public Pessoa salvar(Pessoa pessoa) throws Exception {
		EntityManager em = getEm();
		try {
			em.getTransaction().begin();
			if (pessoa.getId()==null) {
				em.persist(pessoa);
			} else {
				if (!em.contains(pessoa)) {
					if (em.find(Pessoa.class, pessoa.getId()) == null) {
						throw new Exception("Erro ao atualizar o registro!");
					}
				}
				pessoa = em.merge(pessoa);
			}
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
		return pessoa;
		
	}
	
}
