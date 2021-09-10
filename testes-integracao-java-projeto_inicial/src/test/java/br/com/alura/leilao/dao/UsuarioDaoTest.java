package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JpaUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class UsuarioDaoTest {
	
	private UsuarioDao usuarioDao;
	
	private EntityManager em;
	
	@BeforeEach
	private void beforeEach() {
		em = JpaUtil.getEntityManager();
		usuarioDao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	private void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveriaEncontrarUsuarioCadastrado() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("12345678")
				.criar();
			
		em.persist(usuario);
		
		Usuario procurado = usuarioDao.buscarPorUsername(usuario.getNome());
		assertNotNull(procurado);
	}
	
	@Test
	void naoDeveriaEncontrarUsuarioNaoCadastrado() {
		Usuario usuario = new UsuarioBuilder()
			.comNome("fulano")
			.comEmail("fulano@gmail.com")
			.comSenha("12345678")
			.criar();
		
		em.persist(usuario);

		assertThrows(NoResultException.class, () -> usuarioDao.buscarPorUsername("jose"));
	}
	
	@Test
	void deveriaRemoverUmUsuario() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("12345678")
				.criar();
			
		em.persist(usuario);
			
		usuarioDao.deletar(usuario);
		
		assertThrows(NoResultException.class, () -> usuarioDao.buscarPorUsername(usuario.getNome()));

		
	}

}
