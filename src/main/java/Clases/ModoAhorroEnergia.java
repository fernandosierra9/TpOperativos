package Clases;

import java.time.LocalDateTime;

public class ModoAhorroEnergia {



		public void encender(DispositivoInteligente dispositivo, LocalDateTime hora) {
			dispositivo.cambiarModo(new ModoEncendido());
			dispositivo.encender(hora);
		}


	public void apagar (DispositivoInteligente dispositivo, LocalDateTime horaApagado){

		dispositivo.cambiarModo(new ModoApagado());
		dispositivo.apagar(horaApagado);


	}


}
