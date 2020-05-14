package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJpql {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(1L);

		String jpquery = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		TypedQuery<Movimentacao> query = em.createQuery(jpquery, Movimentacao.class);
		query.setParameter("pConta", conta);

		List<Movimentacao> resultList = query.getResultList();
		resultList.forEach(
				result -> System.out.printf(String.format("Descrição: %s  Tipo Movimentação: %s  Valor: %.2f\n",
														   result.getDescricao(), result.getTipoMovimentacao(), result.getValor())));

	}

}
