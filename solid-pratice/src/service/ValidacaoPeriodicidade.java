package service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.ValidacaoException;
import model.Funcionario;

public class ValidacaoPeriodicidade implements ValidacaoReajuste{

	public void validar(Funcionario funcionario, BigDecimal aumento) {
		
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		if (mesesDesdeUltimoReajuste > 6) {
			throw new ValidacaoException("Intervalo de reajuste deve ser maior que 6 meses!");
		}		
				
	}
	
}
