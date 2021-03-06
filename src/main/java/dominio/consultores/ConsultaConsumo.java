package dominio.consultores;

import dominio.dispositivo.DispositivoInteligente;

public abstract class ConsultaConsumo {

    DispositivoInteligente unDI;
    long ultimasNHoras;

    public ConsultaConsumo() {
    }

    public ConsultaConsumo(DispositivoInteligente dispInteligente, long ultimasNHoras) {
        this.unDI = dispInteligente;
        this.ultimasNHoras = ultimasNHoras;
    }

    public abstract double consultar();

    public abstract double consultarDI(DispositivoInteligente unDI);
}