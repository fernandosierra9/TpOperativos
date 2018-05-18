package Clases;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DispositivoEstandar extends DispositivoAbstracto {

	AdaptadorNulo adaptador = new AdaptadorNulo();
	
	boolean inteligente=false;
	
	public DispositivoEstandar(String nombre, double consumo, boolean encendido) {
		super (nombre, consumo, encendido);
		
	}
	void agregarAdaptador() {
	    this.inteligente=true;
	    this.adaptador=new Adaptador();

    }




    @Override
	public boolean esInteligente() {

	    return  inteligente;
    }
	
	@Override 
	public int calcularIntervalo(LocalTime h , LocalTime a) {
	return	adaptador.calcularIntervalo(h,a);
				
		
	
	}
	
	

	@Override
	void registrarUso(LocalDateTime horaEncendido , int horas) {
		adaptador.registrarUso(horaEncendido, horas);

	}

	@Override
	public double getConsumoTotal() {
		
		return adaptador.getConsumoTotal();
	}

	@Override
	public boolean isEncendido() {
		
		return adaptador.isEncendido();
	}

}
