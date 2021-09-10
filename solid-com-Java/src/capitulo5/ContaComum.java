package capitulo5;

public class ContaComum implements ServicoDeRenda{
	
	private ManipuladorDeSaldo manipulador;
	
	public ContaComum() {
		this.manipulador = new ManipuladorDeSaldo();
	}
	
	public void deposita(double valor) {
		manipulador.deposita(valor);
	}

	public void saca(double valor) {
		manipulador.saca(valor);
	}

	public double getSaldo() {
		return manipulador.getSaldo();
	}
	
	public void rende() {
		manipulador.rende(1.1);
	}

}