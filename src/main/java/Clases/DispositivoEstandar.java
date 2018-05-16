package Clases;

public class DispositivoEstandar extends DispositivoAbstracto {

	Adaptador adaptador;
	
	
	
	public DispositivoEstandar(String nombre, double consumo, boolean encendido) {
		super (nombre, consumo, encendido);
		
	}

	
	
	@Override 
	public int calcularIntervalo() {
	return	adaptador.calcularIntervalo();
				
		
	
	}
	
	

	@Override
	void registrarUso() {
		adaptador.registrarUso();

	}

	@Override
	double getConsumoTotal() {
		
		return adaptador.getConsumoTotal();
	}

	@Override
	boolean isEncendido() {
		
		return adaptador.isEncendido();
	}

}
