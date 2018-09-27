package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	private static EntityManagerFactory emf = null;
	
	public static EntityManager getEm() {
		emf = Persistence.createEntityManagerFactory("crudgenerico");
		return emf.createEntityManager();
	}	
}
