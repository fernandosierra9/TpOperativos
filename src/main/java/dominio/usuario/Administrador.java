package dominio.usuario;

import dominio.dispositivo.Dispositivo;
import dominio.dispositivo.DispositivoInteligente;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;


public class Administrador {




	private String nombre;
	private String apellido;
	private Domicilio domicilio;
	private LocalDate fechaAlta;
	private long numId;
	private String username;
	private String password;

	public Administrador(String nombre, String unApellido, LocalDate fecha) {
		this.nombre = nombre;
		this.apellido = unApellido;
		this.fechaAlta = fecha;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate fechaActual() {
		return LocalDate.now();
	}

	public LocalDate fechaAlta() {
		return fechaAlta;
	}

	public long cantMesesComoAdmin() {
		LocalDate ahora = LocalDate.now();
		return fechaAlta.until(ahora, ChronoUnit.MONTHS);
	}


	public void agregarDispositivoDB(Dispositivo dispositivo){




			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplo");
			EntityManager em = emf.createEntityManager();
			EntityTransaction t = em.getTransaction();


			try {

				t.begin();
				em.persist(dispositivo);
				t.commit();
				System.out.println("se inserto dispositivo ");
			}


			catch(Exception e){

			t.rollback();
			System.out.println("Fallo" +e.getMessage());

			}

			finally {
				em.close();
			}




	}


}
