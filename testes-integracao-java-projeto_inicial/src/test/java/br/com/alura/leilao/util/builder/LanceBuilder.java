package br.com.alura.leilao.util.builder;

import java.math.BigDecimal;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

public class LanceBuilder {
	
	private Usuario usuario;
	private BigDecimal valor;
	private Leilao leilao;
	
	public LanceBuilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public LanceBuilder comValor(String valor) {
		this.valor = new BigDecimal(valor);
		return this;
	}
	
	public LanceBuilder comLeilao(Leilao leilao) {
		this.leilao = leilao;
		return this;
	}
	
	public Lance criar() {
		return new Lance(usuario, valor, leilao);
	}

}
