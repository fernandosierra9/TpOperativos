package dominio.simplexservice;

import dominio.dispositivo.Dispositivo;
import dominio.repositories.RepositorioDispositivo;
import org.apache.commons.math3.optim.linear.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimplexBuilder {

    private final LinearConstrainFactory linearConstrainFactory = new LinearConstrainFactory();
    List<Dispositivo> dispositivosDelCliente = new ArrayList<>();
    VectorSimplex vectorSimplex;
    SimplexSolver simplexSolver;

    public SimplexBuilder(List<Dispositivo> dispositivosDelCliente) {
        this.dispositivosDelCliente = dispositivosDelCliente;
        vectorSimplex = new VectorSimplex(dispositivosDelCliente);
    }

    public LinearObjectiveFunction funcionEconomicaBuild() {
        LinearObjectiveFunction funcion = new LinearObjectiveFunction(
                vectorSimplex.devolverCoeficientesDeFuncionEconomicaObjetivo(), 0);
        return funcion;
    }

    public Collection<LinearConstraint> restriccionesDeLosDispositivosBuild() {

        Collection<LinearConstraint> constraints = new ArrayList<>();
        //El primer parametro del constructor de la funcion debe ser un vector de tamanio de los dispositivos del cliente de todos de coeficiente 1 (Siguiendo el ejemplo de la pagina 1 del TP)
        constraints.add(linearConstrainFactory.createLinearConstrain(vectorSimplex.devolverCoeficientesDeConsumoKwhR1(), Relationship.LEQ, 612));
        for (int i = 0; i < dispositivosDelCliente.size(); i++) {
            constraints.add(new LinearConstraint(
                    vectorSimplex.coefsResctriccionDeUnDispositivo(i),
                    Relationship.GEQ,
                    RepositorioDispositivo.getInstance().restriccionMinimaDe(dispositivosDelCliente.get(i))));
            constraints.add(new LinearConstraint(
                    vectorSimplex.coefsResctriccionDeUnDispositivo(i),
                    Relationship.LEQ,
                    RepositorioDispositivo.getInstance().restriccionMaximaDe(dispositivosDelCliente.get(i))));
        }
        return constraints;
    }

}
