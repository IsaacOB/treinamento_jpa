package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraDadosDaConta {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaId1 = em.find(Conta.class, 1L);
		
		
		em.getTransaction().begin();
		
		contaId1.setSaldo(300.0);
		
		em.getTransaction().commit();		
		
	}

}
