package br.com.alura.leilao.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JpaUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class LeilaoDaoTest {
	
	private EntityManager em;

	private LeilaoDao dao;
	
	@BeforeEach
	private void beforeEach() {
		em = JpaUtil.getEntityManager();
		dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	private void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveriaCadastrarUmLeilao() {
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
		
		Leilao procurado = dao.buscarPorId(leilao.getId());
		assertNotNull(procurado);
	}
	
	@Test
	void deveriaAtualizarUmLeilao() {
		
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
		
		leilao.setNome("mala");
		leilao.setValorInicial(new BigDecimal("300"));
		
		leilao = dao.salvar(leilao);
		
		Leilao procurado = dao.buscarPorId(leilao.getId());
		assertEquals("mala", procurado.getNome());
		assertEquals(new BigDecimal("300"), procurado.getValorInicial());
	}

}
