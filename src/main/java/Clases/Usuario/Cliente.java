package Clases.Usuario;

import Clases.Categoria.AsignadorDeCategoria;
import Clases.Categoria.Categoria;
import Clases.Dispositivo.Dispositivo;
import Clases.Dispositivo.DispositivoEstandar;
import Clases.Dispositivo.DispositivoInteligente;
import Clases.Dispositivo.EstadoApagado;
import Clases.Dispositivo.EstadoDispositivo;
import Clases.Dispositivo.EstadoEncendido;
import Clases.entities.ProcessingDataFailedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private ID identificacion;
    private long telefono;
    private Domicilio domicilio;
    private LocalDate fechaDeAlta;
    private Categoria categoria;
    private String username;
    private String password;
    private double puntosAcumulados = 0;
    private List<Dispositivo> dispositivosEstandar = new ArrayList<>();
    private List<Dispositivo> dispositivosInteligentes = new ArrayList<>();

    public Cliente(String unNombre, String unApellido, String username, ID id, Domicilio unDomicilio, long unTelefono,
                   List<Dispositivo> dispEstandar, List <Dispositivo> dispInteligentes) {

        this.nombre = unNombre;
        this.apellido = unApellido;
        this.identificacion = id;
        this.username = username;
        this.domicilio = unDomicilio;
        this.telefono = unTelefono;
        this.dispositivosEstandar = dispEstandar;
        this.dispositivosInteligentes = dispInteligentes;
        this.fechaDeAlta = LocalDate.now();
    }
    
    public List<Dispositivo> todosLosDispositivos() {
    	
    	List <Dispositivo> todos = new ArrayList<>();
    	
    	todos.addAll(dispositivosEstandar);
    	todos.addAll(dispositivosInteligentes);
    	return todos;
    }
    
    public double puntosAcumulados() {
        return puntosAcumulados;
    }

    public void agregarModuloAdaptador(DispositivoEstandar disp) {
        disp.agregarAdaptadorInteligente();
        this.sumarPuntos(10);
    }

    public boolean algunDispositivoEncendido() {
    	
    	return todosLosDispositivos().stream().anyMatch(disp -> disp.esCiertoEstado(new EstadoEncendido()));
    }

    public long cantidadDeDispositivosEncendidos() {
    	
    	return todosLosDispositivos().stream().filter(disp -> disp.esCiertoEstado(new EstadoEncendido())).count();
    }

    public long cantidadDeDispositivosApagados() {

        return todosLosDispositivos().stream().filter(disp -> disp.esCiertoEstado(new EstadoApagado())).count();
    }

    public int cantidadDeDispositivos() {
        return todosLosDispositivos().size();
    }

    public void agregarDispositivoInteligente(Dispositivo disp) {

        dispositivosInteligentes.add(disp);
        this.sumarPuntos(15);
    }
    
    public void agregarDispositivoEstandar(Dispositivo disp) {
    	
    	dispositivosEstandar.add(disp);
    }

    public void sumarPuntos(int puntos) {
        puntosAcumulados = puntosAcumulados + puntos;
    }

    public void usarDispositivo(Dispositivo dispositivo, int cantHorasEstimativa) {
        
    	dispositivo.serUsado(cantHorasEstimativa);
    }

    public double consumoEnergeticoTotal() {

        return todosLosDispositivos().stream().mapToDouble(disp -> disp.getConsumoTotal()).sum();
    }

    public double obtenerGastosAproximados() {

        return categoria.calcularCostosPara(this);
    }

    public void setCategoria(Categoria unaCategoria) {

        categoria = unaCategoria;
    }

    public Categoria getCategoria() {

        return this.categoria;
    }

    public String nombreCategoria() {

        return this.categoria.getNombreCategoria();
    }

    public String nombre() {
        return this.nombre;
    }

}