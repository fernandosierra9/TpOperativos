package Clases;

import java.time.LocalDateTime;

public class ModoApagado implements ModoDispositivo {
	
	public void encender(DispositivoInteligente dispositivo, LocalDateTime hora) {
		dispositivo.cambiarModo(new ModoEncendido());
		dispositivo.encender(hora);
	}




	public void apagar (DispositivoInteligente dispositivo, LocalDateTime horaApagado) {
		
	}

	

	
	
}
