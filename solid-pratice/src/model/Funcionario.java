package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

	private DadosPessoais dadosPessoais;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}
	
	public void atualizarSalario(BigDecimal salarioNovo) {
		this.dadosPessoais.setSalario(salarioNovo);
		this.dataUltimoReajuste = LocalDate.now();		
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void promover(Cargo cargoNovo) {
		this.dadosPessoais.setCargo(cargoNovo);
	}
	
	public BigDecimal getSalario() {
		return this.dadosPessoais.getSalario();
	}
	
	public Cargo getCargo() {
		return this.dadosPessoais.getCargo();
	}
	

}

