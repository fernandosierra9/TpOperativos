package Clases;

public class Actuador implements Observador {


    @Override
    public void update() {

    }

    public void enviarAccion(DispositivoInteligente dispositivo , Sensor sensor, Regla regla){


        if(sensor.activo(regla.condicion())){

    regla.accion(dispositivo);

        }


            }


}
