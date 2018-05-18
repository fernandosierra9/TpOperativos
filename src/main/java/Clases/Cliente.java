package Clases;

import Clases.entities.ProcessingDataFailedException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	String nombreCompleto;
	String apellido;
	ID identificacion;
	long telefono;
	Domicilio domicilio;
	LocalDate fechaDeAlta;
	Categoria categoria;
	String username;
	String password;
	List <DispositivoAbstracto> dispositivos = new ArrayList <>();
	double puntosAcumulados = 0;
	
	public Cliente(String unNombreCompleto, String unApellido, String username, ID id, Domicilio unDomicilio, long unTelefono,
			List<DispositivoAbstracto> listaDispositivos) {
		
		this.nombreCompleto = unNombreCompleto;
		this.apellido = unApellido;
		this.identificacion = id;
		this.username = username;
		this.domicilio = unDomicilio;
		this.telefono = unTelefono;
		this.dispositivos = listaDispositivos;
		this.fechaDeAlta = LocalDate.now();
		this.actualizarCategoria();
	}
	
	public void actualizarCategoria() {

		try {
			AsignadorDeCategoria asignadorDeCategoria = this.asignadorDeCategoria();
			this.setCategoria(asignadorDeCategoria.definirCategoriaPara(this));
		} catch (ProcessingDataFailedException e) {
			e.printStackTrace();
		}

	}
	public AsignadorDeCategoria asignadorDeCategoria(){
		AsignadorDeCategoria asignadorDeCategoria = AsignadorDeCategoria.instance;
		return asignadorDeCategoria;
	}
	
	public boolean algunDispositivoEncendido() {
		
		return dispositivos.stream().filter(disp->disp.esInteligente()).anyMatch(disp -> disp.isEncendido());
	}
	
	public long cantidadDeDispositivosEncendidos() {
		
		return dispositivos.stream().filter(disp->disp.esInteligente()).filter(disp -> disp.isEncendido()).count();
	}
	
	public long cantidadDeDispositivosApagados() {
		
		return dispositivos.stream().filter(disp->disp.esInteligente()).filter(disp -> !disp.isEncendido()).count();
	}
	
	public int cantidadDeDispositivos() {
		
		return dispositivos.size();
	}


	public void agregarModuloAdaptador(DispositivoEstandar disp)
	{
		disp.agregarAdaptadorInteligente();
		this.sumarPuntos(10);
	}




	public void agregarDispositivo(DispositivoAbstracto disp) {
		
		dispositivos.add(disp);
		this.sumarPuntos(15);
	}
	
	public void usarDispositivo(DispositivoAbstracto disp,LocalDateTime horarioDeEncendido, int horas) {
		
		disp.registrarUso(horarioDeEncendido, horas);
	}
	
	public double consumoEnergeticoTotal() {
		
		return dispositivos.stream().mapToDouble(disp -> disp.getConsumoTotal()).sum();
	}
	
	public double obtenerGastosAproximados() {
		
		this.actualizarCategoria();
		return categoria.calcularCostosPara(this);
	}
	
	public void setCategoria(Categoria unaCategoria) {
		
		categoria = unaCategoria;
	}
	
	public Categoria getCategoria() {
		
		return this.categoria;
	}
	public  String nombreCategoria() {

		return this.categoria.getNombreCategoria();
	}

	public String nombreCompleto() {
		return this.nombreCompleto;
	}


	public void sumarPuntos(int puntos)
	{
		puntosAcumulados = puntosAcumulados + puntos;
	}






}
