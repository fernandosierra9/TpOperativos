package Clases;

import java.time.LocalDateTime;

public interface ModoDispositivo {
	
	void encender (DispositivoInteligente dispositivo, LocalDateTime hora);
	void apagar (DispositivoInteligente dispositivo, LocalDateTime horaApagado);
	
}
	
	
