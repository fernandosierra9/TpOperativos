package Clases;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface InterfaceDispositivoInteligente {

    public int calcularIntervalo(LocalTime h , LocalTime a);



    void registrarUso(LocalDateTime horaEncendido , int horas) ;

    public double getConsumoTotal() ;

    public boolean isEncendido();




}
