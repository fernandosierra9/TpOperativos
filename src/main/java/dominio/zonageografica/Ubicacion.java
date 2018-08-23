package dominio.zonageografica;

import dominio.usuario.Cliente;

public class Ubicacion {

    private double posicionX;
    private double posicionY;

    public Ubicacion(double posicionX,double posicionY){

        this.posicionX=posicionX;
        this.posicionY=posicionY;
    }

    public Double calcularDistancia (Ubicacion ubicacionCliente) {

        double posicionXcliente =ubicacionCliente.getPosicionX();
        double posicionYcliente =ubicacionCliente.getPosicionX();
        return Math.hypot(posicionXcliente-posicionX, posicionYcliente-posicionY);

    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }


}