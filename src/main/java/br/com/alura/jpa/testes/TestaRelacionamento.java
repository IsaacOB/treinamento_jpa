package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.enums.TipoMovimentacaoEnum;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();

		conta.setAgencia(1234);
		conta.setNumero(5678);
		conta.setTitular("Isaac");
		conta.setSaldo(100.0);

		Movimentacao movimentacao = new Movimentacao();

		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churras");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacaoEnum.ENTRADA);
		movimentacao.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();

		em.close();

	}

}
