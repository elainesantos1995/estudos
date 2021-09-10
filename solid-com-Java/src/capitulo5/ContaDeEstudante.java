package capitulo5;

public class ContaDeEstudante implements ServicoDeSaldo{
	
	private ManipuladorDeSaldo manipulador;
	private int milhas;

	public ContaDeEstudante() {
		this.manipulador = new ManipuladorDeSaldo();
	}

	public int getMilhas() {
		return milhas;
	}
	
	public void deposita(double valor) {
		manipulador.deposita(valor);
		this.milhas += (int) valor;
	}

	public double getSaldo() {
		return manipulador.getSaldo();
	}

	@Override
	public void saca(double valor) {
		manipulador.saca(valor);
		
	}

}
