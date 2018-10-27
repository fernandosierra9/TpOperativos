package dominio.dispositivo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "dispositivoInteligente")
public class DispositivoInteligente extends Dispositivo {

	@Embedded
	public EstadoDispositivo estadoDispositivo;
	public LocalDateTime horaEncendido;
	public LocalDateTime horaApagado;
	@Embedded
	public List<Intervalo> intervalosDeUso = new ArrayList<>();

	public DispositivoInteligente(DispositivoInteligenteBuilder builder) {
		this.nombre = builder.nombre;
		this.consumoEstimadoPorHora = builder.consumoEstimadoPorHora;
		this.equipoConcreto = builder.equipoConcreto;
		this.estadoDispositivo = builder.estadoDispositivo;
		this.horaEncendido = builder.horaEncendido;
		this.horaApagado = builder.horaApagado;
		this.tipoDispositivo = builder.tipoDispositivo;
		this.intervalosDeUso = builder.intervalosDeUso;

	}

	public DispositivoInteligente() {

	}

	public LocalDateTime getHoraEncendido() {
		return horaEncendido;
	}

	public void setHoraEncendido(LocalDateTime horaEncendido) {
		this.horaEncendido = horaEncendido;
	}

	public LocalDateTime getHoraApagado() {
		return horaApagado;
	}

	public void setHoraApagado(LocalDateTime horaApagado) {
		this.horaApagado = horaApagado;
	}

	public EstadoDispositivo estadoDispositivo() {
		return estadoDispositivo;
	}

	public double getConsumoEstimadoPorHora() {

		return consumoEstimadoPorHora;
	}

	public boolean estaEncendido() {
		return estadoDispositivo.estaEncendido();
	}

	public boolean estaApagado() {
		return estadoDispositivo.estaApagado();
	}

	public void apagar() {
		estadoDispositivo.apagar(this);
		setHoraApagado(LocalDateTime.now());
		System.out.println(horaEncendido.getHour());
		System.out.println(horaApagado.getHour());
		intervalosDeUso.add(new Intervalo(horaEncendido, horaApagado));
		this.reiniciar();
	}

	public List<Intervalo> encendidoEntre(LocalDateTime fecha, LocalDateTime otraFecha) {

		return intervalosDeUso.stream().filter(i -> i.estaEntre(fecha, otraFecha)).collect(Collectors.toList());
	}

	private void reiniciar() {

		this.setHoraApagado(null);
		this.setHoraEncendido(null);
	}

	public double consumoParaIntervalo(Intervalo i) {

		//System.out.println("intervalo en horas " + i.intervaloEnHoras());
		//System.out.println("consumo por hora" + consumoEstimadoPorHora);
		return i.intervaloEnHoras() * consumoEstimadoPorHora;
	}

	public double consumoParaIntervalos(List<Intervalo> intervalos) {

		//System.out.println("intervalos tamanio:" + intervalos.size());
		return intervalos.stream().mapToDouble(i -> consumoParaIntervalo(i)).sum();
	}

	public void encender() {
		estadoDispositivo.encender(this);
		setHoraEncendido(LocalDateTime.now());
	}

	public void ponerModoAhorro() {
		estadoDispositivo.ponerModoAhorro(this);
	}

	public List<Intervalo> buscarIntervalosEntre(LocalDateTime fecha, LocalDateTime otraFecha) {

		return intervalosDeUso.stream().filter(i -> i.estaEntre(fecha, otraFecha)).collect(Collectors.toList());
	}

	public double consumoUltimasNHoras(long horas) {

		Intervalo ultimasNHoras = new Intervalo(LocalDateTime.now().minusHours(horas),LocalDateTime.now());
		
		List <Intervalo> intervalosDentro = intervalosDeUso.stream().filter(i-> i.caeDentroDe(ultimasNHoras)).collect(Collectors.toList());
		
		if (intervalosDentro.isEmpty()) {

			return 0;
		}

		else
			return this.consumoParaIntervalos(intervalosDentro);
	}

	public void cambiarEstado(EstadoDispositivo estadoNuevo) {

		estadoDispositivo = estadoNuevo;
	}

	public void agregarIntervalo(Intervalo i) {

		intervalosDeUso.add(i);
	}

	public List<Intervalo> getIntervalosDeUso() {
		return intervalosDeUso;
	}

	// Para aumentar consumo en un 1000%
	// aumentarConsumoPor(consumoEstimadoPorHora*10); -- PARA TEST ENTREGA 3
	public void aumentarConsumoPor(double cantidad) {

		this.consumoEstimadoPorHora += cantidad;
	}

	public void reducirConsumoPor(double cantidad) {

		consumoEstimadoPorHora = Math.max(0.0, consumoEstimadoPorHora - cantidad);
	}

	public double getConsumoTotal() {

		return this.consumoParaIntervalos(intervalosDeUso);
	}

	public boolean estaEnModoAhorro() {

		return estadoDispositivo.estaEnModoAhorro();
	}

	public int getPuntos() {
		return 15;
	}

	public String getUrl() {
		return "/usuario/dispositivo/" + this.getId();
	}

	public static class DispositivoInteligenteBuilder {

		private final String nombre;
		private EstadoDispositivo estadoDispositivo = new EstadoApagado();
		private LocalDateTime horaEncendido = null;
		private LocalDateTime horaApagado = null;
		private double consumoEstimadoPorHora;
		private String equipoConcreto;
		private TipoDispositivo tipoDispositivo;
		private List<Intervalo> intervalosDeUso;

		public DispositivoInteligenteBuilder(String nombre) {
			this.nombre = nombre;

		}

		public DispositivoInteligenteBuilder tipoDispositivo(TipoDispositivo tipoDispositivo) {
			this.tipoDispositivo = tipoDispositivo;
			return this;
		}

		public DispositivoInteligenteBuilder intervalosDeUso(List<Intervalo> intervalosDeUso) {

			this.intervalosDeUso = intervalosDeUso;
			return this;
		}

		public DispositivoInteligenteBuilder horaEncendido(LocalDateTime horaEncendido) {

			this.horaEncendido = horaEncendido;
			return this;

		}

		public DispositivoInteligenteBuilder horaApagado(LocalDateTime horaApagado) {

			this.horaApagado = horaApagado;
			return this;
		}

		public DispositivoInteligenteBuilder estadoDispositivo(EstadoDispositivo estadoDispositivo) {

			this.estadoDispositivo = estadoDispositivo;
			return this;

		}

		public DispositivoInteligenteBuilder consumoEstimadoPorHora(Double consumoEstimadoPorHora) {
			this.consumoEstimadoPorHora = consumoEstimadoPorHora;
			return this;
		}

		public DispositivoInteligenteBuilder equipoConcreto(String equipoConcreto) {
			this.equipoConcreto = equipoConcreto;
			return this;
		}

		public DispositivoInteligente build() {
			return new DispositivoInteligente(this);
		}

	}

}
