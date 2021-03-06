package test.actuadores;

import dominio.actuador.OrdenEncenderDI;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.EstadoApagado;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class testOrdenEncenderDI {

    OrdenEncenderDI ordenEncenderDI;
    DispositivoInteligente unDI;

    @Before
    public void setUp() {

        unDI = Mockito.spy(new DispositivoInteligente.DispositivoInteligenteBuilder("MockDI")
                .estadoDispositivo(new EstadoApagado()).build());

        ordenEncenderDI = new OrdenEncenderDI(unDI);
    }

    @Test
    public void testDIApagadoSeEnciende() {
        ordenEncenderDI.ejecutar();
        assertTrue(unDI.estaEncendido());
    }

    @Test
    public void testDIApagadoSigueApagado() {
        ordenEncenderDI.ejecutarInversa();
        assertTrue(unDI.estaApagado());
    }
}
