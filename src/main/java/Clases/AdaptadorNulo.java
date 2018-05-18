package Clases;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdaptadorNulo extends DispositivoInteligente {

    public AdaptadorNulo(String nombre, double consumo, boolean encendido) {
        super (nombre, consumo, encendido);
    }
    public int calcularIntervalo(LocalTime h , LocalTime a) {
        return	0;



    }

    @Override
    public void registrarUso(LocalDateTime horaEncendido , int horas) {


    }



    public double getConsumoTotal() {

        return 0;
    }

    public boolean isEncendido() {

        return false;
    }




}
