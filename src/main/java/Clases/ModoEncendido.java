package Clases;

import java.time.LocalDateTime;

public class ModoEncendido implements ModoDispositivo {


	public void encender(DispositivoInteligente dispositivo, LocalDateTime hora) {

	}
	public void apagar (DispositivoInteligente dispositivo, LocalDateTime horaApagado){

		dispositivo.cambiarModo(new ModoApagado());
		dispositivo.apagar(horaApagado);


	}



}
