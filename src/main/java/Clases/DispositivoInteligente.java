package Clases;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DispositivoInteligente extends DispositivoAbstracto {

	public DispositivoInteligente(String nombre, double consumo, boolean encendido) {
		super(nombre, consumo, encendido);

	}

	@Override
	public int calcularIntervalo(LocalTime horario, LocalTime otroHorario) {
		return 0;
	}

    public void registrarUso(LocalDateTime horaEncendido, int horas) {

        this.encender(horaEncendido);

        LocalDateTime horaApagado = horaEncendido.plusHours(horas);

        this.apagar(horaApagado);

        horasDeUso += horaEncendido.until(horaApagado,ChronoUnit.HOURS);
        consumoTotal += horasDeUso * this.consumo;
        this.reiniciar();
    }
	@Override
	public boolean esInteligente() {

		return true;
	}

}
