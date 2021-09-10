package service.promocao;

import exceptions.ValidacaoException;
import model.Cargo;
import model.Funcionario;

public class PromocaoService {
	
	public void validarPromocao(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();
		
		if(Cargo.GERENTE == funcionario.getCargo()) {
			throw new ValidacaoException("Não é possível subir de cargo!");
		}
		
		if(metaBatida) {
			Cargo cargoNovo = cargoAtual.getProximoCargo();
			funcionario.promover(cargoNovo);
		}else {
			throw new ValidacaoException("Funcionário não atingiu a meta!");
		}
	}

}
