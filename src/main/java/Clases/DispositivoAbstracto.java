package Clases;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class DispositivoAbstracto {
	
	
	String nombre;
	double consumo;
	boolean encendido = false;
	double consumoTotal = 0;
	LocalDateTime horaEncendido;
	LocalDateTime horaApagado;
	double horasDeUso = 0;
	
 
		
	public DispositivoAbstracto(String nombre, double consumo, boolean encendido) {
	this.nombre = nombre;
		this.consumo = consumo;
		this.encendido = encendido;
}





	abstract public int calcularIntervalo(LocalTime horario, LocalTime otroHorario);
	
	abstract void registrarUso(LocalDateTime horaEncendido, int horas);
	
	public void reiniciar() {
		
		this.horaApagado = null;
		this.horaEncendido = null;
	}
	
	public void encender(LocalDateTime horaEncendido) {
		
		if (!encendido) {
			
			encendido = true;
		}
		
		this.horaEncendido = horaEncendido;
	}
	
	
	public void apagar(LocalDateTime horaApagado) {
		
		encendido = false;
		
		this.horaApagado = horaApagado;
		
	}
	
	public String getNombre() {
		
		return nombre;
	}

	 abstract boolean esInteligente ();

public boolean isEncendido() {
		
		return encendido;
	}
public double getConsumoTotal() {
	
	return consumoTotal;
}
	
	
	
	

}
