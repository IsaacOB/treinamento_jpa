package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJpqlMovimentacaoCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Categoria categoria = new Categoria();
		categoria.setId(1L);

		String jpquery = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		TypedQuery<Movimentacao> query = em.createQuery(jpquery, Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> resultList = query.getResultList();
		resultList.forEach(
				result -> System.out.printf(String.format("Descrição: %s  Tipo Movimentação: %s  Valor: %.2f Categorias: %s\n",
														   result.getDescricao(), result.getTipoMovimentacao(), result.getValor(), result.getCategoria())));


	}

}
