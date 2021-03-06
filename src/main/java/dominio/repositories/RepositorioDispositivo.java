package dominio.repositories;

import dominio.dispositivo.Dispositivo;
import dominio.dispositivo.DispositivoEstandar;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.TipoDispositivo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDispositivo {
    // public static RepositorioDispositivo instance;
    //List<Dispositivo> dispositivos = new ArrayList<>();
    private static RepositorioDispositivo instance = new RepositorioDispositivo();

    List<DispositivoInteligente> inteligentes = new ArrayList<>();
    List<DispositivoEstandar> estandars = new ArrayList<>();

    private RepositorioDispositivo() {
        DispositivoInteligente aireAcondicionado3500 = new DispositivoInteligente.DispositivoInteligenteBuilder("aireAcondicionado").equipoConcreto("De 3500 frigorias").tipoDispositivo(TipoDispositivo.AIREACONDICIONADO).consumoEstimadoPorHora(1.613).build();
        DispositivoInteligente aireAcondicionado2200 = new DispositivoInteligente.DispositivoInteligenteBuilder("aireAcondicionado").equipoConcreto("De 2200 frigorias").tipoDispositivo(TipoDispositivo.AIREACONDICIONADO).consumoEstimadoPorHora(1.013).build();

        DispositivoEstandar televisorTuboFluor21 = new DispositivoEstandar.DispositivoEstandarBuilder("televisor").equipoConcreto("Color de tubo fluorescente de 21").tipoDispositivo(TipoDispositivo.TELEVISOR).consumoEstimadoPorHora(0.075).build();
        DispositivoEstandar televisorTuboFluor2943 = new DispositivoEstandar.DispositivoEstandarBuilder("televisor").equipoConcreto("Color de tubo fluorescente de 29 a 34").tipoDispositivo(TipoDispositivo.TELEVISOR).consumoEstimadoPorHora(0.175).build();
        DispositivoEstandar televisorLCD40 = new DispositivoEstandar.DispositivoEstandarBuilder("televisor").equipoConcreto("LCD de 40").tipoDispositivo(TipoDispositivo.TELEVISOR).consumoEstimadoPorHora(0.18).build();
        DispositivoInteligente televisorLED24 = new DispositivoInteligente.DispositivoInteligenteBuilder("televisor").equipoConcreto("LED de 24").tipoDispositivo(TipoDispositivo.TELEVISOR).consumoEstimadoPorHora(0.04).build();
        DispositivoInteligente televisorLED32 = new DispositivoInteligente.DispositivoInteligenteBuilder("televisor").equipoConcreto("LED de 32").tipoDispositivo(TipoDispositivo.TELEVISOR).consumoEstimadoPorHora(0.055).build();
        DispositivoInteligente televisorLED40 = new DispositivoInteligente.DispositivoInteligenteBuilder("televisor").equipoConcreto("LED de 40").tipoDispositivo(TipoDispositivo.TELEVISOR).consumoEstimadoPorHora(0.08).build();

        DispositivoInteligente heladeraConFreezer = new DispositivoInteligente.DispositivoInteligenteBuilder("heladera").equipoConcreto("Con freezer").tipoDispositivo(TipoDispositivo.OTRO).consumoEstimadoPorHora(0.09).build();
        DispositivoInteligente heladeraSinFreezer = new DispositivoInteligente.DispositivoInteligenteBuilder("heladera").equipoConcreto("Sin freezer").tipoDispositivo(TipoDispositivo.OTRO).consumoEstimadoPorHora(0.075).build();


        DispositivoEstandar lavarropas5kgAgua = new DispositivoEstandar.DispositivoEstandarBuilder("lavarropas").equipoConcreto("Automatico de 5kg con calentamiento de agua").tipoDispositivo(TipoDispositivo.LAVARROPAS).consumoEstimadoPorHora(0.875).build();
        DispositivoInteligente lavarropas5kg = new DispositivoInteligente.DispositivoInteligenteBuilder("lavarropas").equipoConcreto("Automatico de 5kg").tipoDispositivo(TipoDispositivo.LAVARROPAS).consumoEstimadoPorHora(0.175).build();
        DispositivoEstandar lavarropas5kgSemiautomatico = new DispositivoEstandar.DispositivoEstandarBuilder("lavarropas").equipoConcreto("Semi-automatico de 5kg").tipoDispositivo(TipoDispositivo.LAVARROPAS).consumoEstimadoPorHora(0.1275).build();

        DispositivoEstandar ventiladorDePie = new DispositivoEstandar.DispositivoEstandarBuilder("ventilador").equipoConcreto("De pie").tipoDispositivo(TipoDispositivo.VENTILADOR).consumoEstimadoPorHora(0.09).build();
        DispositivoInteligente ventiladorDeTecho = new DispositivoInteligente.DispositivoInteligenteBuilder("ventilador").equipoConcreto("De techo").tipoDispositivo(TipoDispositivo.VENTILADOR).consumoEstimadoPorHora(0.06).build();

        DispositivoInteligente lamparaHalogena40W = new DispositivoInteligente.DispositivoInteligenteBuilder("lampara").equipoConcreto("Halogena de 40W").tipoDispositivo(TipoDispositivo.LAMPARA).consumoEstimadoPorHora(0.04).build();
        DispositivoInteligente lamparaHalogena60W = new DispositivoInteligente.DispositivoInteligenteBuilder("lampara").equipoConcreto("Halogena de 60W").tipoDispositivo(TipoDispositivo.LAMPARA).consumoEstimadoPorHora(0.06).build();
        DispositivoInteligente lamparaHalogena100W = new DispositivoInteligente.DispositivoInteligenteBuilder("lampara").equipoConcreto("Halogena de 100W").tipoDispositivo(TipoDispositivo.LAMPARA).consumoEstimadoPorHora(0.015).build();
        DispositivoInteligente lampara11W = new DispositivoInteligente.DispositivoInteligenteBuilder("lampara").equipoConcreto("De 11W").tipoDispositivo(TipoDispositivo.LAMPARA).consumoEstimadoPorHora(0.011).build();
        DispositivoInteligente lampara15W = new DispositivoInteligente.DispositivoInteligenteBuilder("lampara").equipoConcreto("De 15W").tipoDispositivo(TipoDispositivo.LAMPARA).consumoEstimadoPorHora(0.015).build();
        DispositivoInteligente lampara20W = new DispositivoInteligente.DispositivoInteligenteBuilder("lampara").equipoConcreto("De 20W").tipoDispositivo(TipoDispositivo.LAMPARA).consumoEstimadoPorHora(0.02).build();

        DispositivoInteligente pc = new DispositivoInteligente.DispositivoInteligenteBuilder("PC").equipoConcreto("De escritorio").tipoDispositivo(TipoDispositivo.COMPUTADORA).consumoEstimadoPorHora(0.4).build();

        DispositivoEstandar microondas = new DispositivoEstandar.DispositivoEstandarBuilder("microondas").equipoConcreto("Convencional").tipoDispositivo(TipoDispositivo.MICROONDAS).consumoEstimadoPorHora(0.64).build();
        DispositivoEstandar plancha = new DispositivoEstandar.DispositivoEstandarBuilder("plancha").equipoConcreto("A vapor").tipoDispositivo(TipoDispositivo.PLANCHA).consumoEstimadoPorHora(0.75).build();

        inteligentes.add(aireAcondicionado3500);
        inteligentes.add(aireAcondicionado2200);
        estandars.add(televisorTuboFluor21);
        estandars.add(televisorTuboFluor2943);
        estandars.add(televisorLCD40);
        inteligentes.add(televisorLED24);
        inteligentes.add(televisorLED32);
        inteligentes.add(televisorLED40);
        inteligentes.add(heladeraConFreezer);
        inteligentes.add(heladeraSinFreezer);
        estandars.add(lavarropas5kgAgua);
        inteligentes.add(lavarropas5kg);
        estandars.add(lavarropas5kgSemiautomatico);
        estandars.add(ventiladorDePie);
        inteligentes.add(ventiladorDeTecho);
        inteligentes.add(lamparaHalogena40W);
        inteligentes.add(lamparaHalogena60W);
        inteligentes.add(lamparaHalogena100W);
        inteligentes.add(lampara11W);
        inteligentes.add(lampara15W);
        inteligentes.add(lampara20W);
        inteligentes.add(pc);
        estandars.add(microondas);
        estandars.add(plancha);

    }

    public static RepositorioDispositivo getInstance() {
        return instance;
    }

    public List<Dispositivo> getTodosLosDispositivos() {

        List<Dispositivo> todos = new ArrayList<>();
        todos.addAll(inteligentes);
        todos.addAll(estandars);
        return todos;
    }

    public List<DispositivoInteligente> getInteligentes() {
        return inteligentes;
    }

    public List<DispositivoEstandar> getEstandars() {
        return estandars;
    }

    public DispositivoInteligente traerDispositivoInteligenteDeNombreConcreto(String nombre, String equipoConcreto) {
        return inteligentes.stream().filter(dispositivo -> nombre.equals(dispositivo.getNombre()) && equipoConcreto.equals(dispositivo.getEquipoConcreto())).collect(Collectors.toList()).get(0);
    }

    public DispositivoEstandar traerDispositivoEstandarDeNombreConcreto(String nombre, String equipoConcreto) {
        return estandars.stream().filter(dispositivo -> nombre.equals(dispositivo.getNombre()) && equipoConcreto.equals(dispositivo.getEquipoConcreto())).collect(Collectors.toList()).get(0);
    }

    public Dispositivo dispBuscadoDelRepositorio(Dispositivo dispositivo) {
        return this.getTodosLosDispositivos().stream()
                .filter(disp -> dispositivo.getEquipoConcreto() == disp.getEquipoConcreto() && dispositivo.getNombre() == disp.getNombre())
                .collect(Collectors.toList()).get(0);
    }

    public double coefConsumoKwhDispositivo(Dispositivo dispositivoDelCliente) {
        return this.dispBuscadoDelRepositorio(dispositivoDelCliente).getConsumoEstimadoPorHora();
    }

}
