package dominio.transformador;

import dominio.dispositivo.Dispositivo;
import dominio.dispositivo.DispositivoEstandar;
import dominio.dispositivo.DispositivoInteligente;

import dominio.usuario.Cliente;
import dominio.usuario.Domicilio;
import dominio.usuario.ID;
import dominio.usuario.TiposId;
import dominio.zonageografica.Ubicacion;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import java.util.ArrayList;
import java.util.List;

public class TransformadorManager implements WithGlobalEntityManager,TransactionalOps  {
/*
    public void persistirCliente()
    {
        withTransaction(()->{
            Transformador transformadorList = RepositorioTransformadores.getInstance().obtenerTransformadores();

            transformadorList.stream().forEach(transformador -> {
                entityManager().persist(transformador);
                entityManager().getTransaction().commit();
            });

        });
    }
*/
}
