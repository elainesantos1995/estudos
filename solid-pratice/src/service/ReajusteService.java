package service;

import java.math.BigDecimal;
import java.util.List;

import model.Funcionario;

public class ReajusteService {

	private List<ValidacaoReajuste> validacoes;
	
	public ReajusteService(List<ValidacaoReajuste> validacoes){
		this.validacoes = validacoes;
	}
	
	public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
		
		this.validacoes.forEach(validacao -> {
			validacao.validar(funcionario, aumento);
		});			
		
		BigDecimal salarioNovo = funcionario.getSalario();
		funcionario.atualizarSalario(salarioNovo);
		
	}
	
}
