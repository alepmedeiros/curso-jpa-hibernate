package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	private static EntityManagerFactory emf = null;
	
	public static EntityManager getEm() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("hibernatejpa");
		}
		return emf.createEntityManager();
	}
	
}
