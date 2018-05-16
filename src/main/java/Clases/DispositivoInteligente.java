package Clases;

public class DispositivoInteligente extends DispositivoAbstracto {

	public DispositivoInteligente(String nombre, double consumo, boolean encendido) {
		super(nombre, consumo, encendido);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularIntervalo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void registrarUso() {
		// TODO Auto-generated method stub

	}

	@Override
	double getConsumoTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean isEncendido() {
		// TODO Auto-generated method stub
		return false;
	}

}
