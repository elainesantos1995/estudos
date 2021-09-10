package service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements Reajuste, ReajusteTributavel{
	
	private BigDecimal valor;
	private LocalDate data;
	
	public Promocao(BigDecimal valor) {
		this.valor = valor;
		this.data = LocalDate.now();
	}

	@Override
	public BigDecimal valor() {
		return valor.multiply(new BigDecimal("0.5"));
	}

	@Override
	public LocalDate data() {
		return this.data;
	}

	@Override
	public BigDecimal valorDoImposto() {
		return valor.multiply(new BigDecimal("0.1"));
	}	
	
	

}
