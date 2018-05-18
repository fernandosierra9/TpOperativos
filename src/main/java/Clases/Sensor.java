package Clases;

import com.sun.javafx.scene.control.skin.VirtualFlow;

public class Sensor implements Observador,SujetoObservable{


    private VirtualFlow.ArrayLinkedList<Observador> observadores;


    public void  agregarObservador (Observador unObservador) {

add.observadores(unObservador);

    }
    @Override
    public void update() {

    }

    @Override
    public void notificar() {
        for(Observador o:observadores) {


        }

    }
}
