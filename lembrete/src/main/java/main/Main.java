package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Lembrete;

public class Main {

	private static EntityManagerFactory emf; 
	
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory( "hibernatejpa");
		
		//Persistencia dos dados
//		Lembrete lembrete = new Lembrete();
//		lembrete.setTitulo("Comprar leite");
//		lembrete.setDescricao("Hoje as 18:15");
//		
//		EntityManager em = emf.createEntityManager();
//
//		try {
//			em.getTransaction().begin();
//			em.persist(lembrete);
//			em.getTransaction().commit();
//		}catch (Exception e) {
//			em.getTransaction().rollback();
//			
//			System.out.println("Insert: "+ e.getMessage());
//		}finally {
//			em.close();
//		}
		
		//Leitura dos dados
//		List<Lembrete> lembretes = null;
//		
//		EntityManager em = emf.createEntityManager();
//
//		try {
//			lembretes = em.createQuery("from Lembrete").getResultList();
//		}catch (Exception e) {			
//			System.out.println("List all: "+ e.getMessage());
//		}finally {
//			em.close();
//		}		
//		
//		if (lembretes != null) {
//			lembretes.forEach(System.out::println);
//		}
	
		//Listar por um unido ID
//		EntityManager em = emf.createEntityManager();
//		
//		Lembrete lembrete = null;
//		
//		try {
//			lembrete = em.find(Lembrete.class, 1L);
//			
//			System.out.println(lembrete);
//		}catch (Exception e) {			
//			System.out.println(e.getMessage());
//		}finally {
//			em.close();
//		}		
		
		//Listar por titulos
//		EntityManager em = emf.createEntityManager();
//		
//		List<Lembrete> lembretes = null;
//		
//		try {
//			lembretes = em.createQuery("from Lembrete l where l.titulo LIKE '%comprar%'").getResultList();
//		}catch (Exception e) {			
//			System.out.println("List all = " + e.getMessage());
//		}finally {
//			em.close();
//		}		
//
//		if (lembretes != null) {
//			lembretes.forEach(System.out::println);
//		}		
		
		//Atualizacao de registro
//		EntityManager em = emf.createEntityManager();
//		
//		try {
//			Lembrete lembrete =  em.find(Lembrete.class, 1L);
//			
//			lembrete.setTitulo("Comprar café");
//			lembrete.setDescricao("Hoje as 08:30");
//			
//			em.getTransaction().begin();
//			em.merge(lembrete);
//			em.getTransaction().commit();
//			
//		}catch (Exception e) {
//			em.getTransaction().rollback();
//			
//			System.out.println("UPDATE = " + e.getMessage());
//		}finally {
//			em.close();
//		}
		
		//Excluindo registro
		EntityManager em = emf.createEntityManager();
		
		try {
			Lembrete lembrete =  em.find(Lembrete.class, 1L);
			
			em.getTransaction().begin();
			em.remove(lembrete);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
			
			System.out.println("DELETE = " + e.getMessage());
		}finally {
			em.close();
		}	
		
	}
	
}
