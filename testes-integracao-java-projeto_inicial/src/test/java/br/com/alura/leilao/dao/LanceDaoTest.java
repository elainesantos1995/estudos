package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JpaUtil;
import br.com.alura.leilao.util.builder.LanceBuilder;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class LanceDaoTest {
	
	private EntityManager em;

	private LanceDao dao;
	
	@BeforeEach
	private void beforeEach() {
		em = JpaUtil.getEntityManager();
		dao = new LanceDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	private void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveriaTrazerOMaiorLanceDoLeilao() {
		
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("12345678")
				.criar();
		
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comNome("mochila")
				.comValorInicial("70")
				.comdata(LocalDate.now())
				.comUsuario(usuario)
			.criar();
		
		em.persist(leilao);
		
		Lance lance1 = new LanceBuilder()
				.comUsuario(usuario)
				.comValor("800")
				.comLeilao(leilao)
				.criar();
		
		em.persist(lance1);
		
		Lance lance2 = new LanceBuilder()
				.comUsuario(usuario)
				.comValor("1000")
				.comLeilao(leilao)
				.criar();
		
		em.persist(lance2);
		
		Lance procurado = dao.buscarMaiorLanceDoLeilao(leilao);
		
		assertEquals(new BigDecimal("1000"), procurado.getValor());
		
	}

}
