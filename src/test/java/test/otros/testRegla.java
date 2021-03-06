package test.otros;

import dominio.actuador.OrdenEncenderDI;
import dominio.dispositivo.DispositivoInteligente;
import dominio.dispositivo.EstadoApagado;
import dominio.regla.Regla;
import dominio.sensor.Condicion;
import dominio.sensor.CondicionPorIgual;
import dominio.sensor.CondicionPorMayor;
import dominio.sensor.CondicionPorMenor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class testRegla {

    OrdenEncenderDI mockActuador;
    Regla regla;
    CondicionPorMayor mockCondicion;
    CondicionPorMenor otroMockCondicion;
    CondicionPorIgual mockCondicionNoCumplida;
    DispositivoInteligente mockDI;

    @Before
    public void setUp() {

        List<Condicion> listaCondiciones = new ArrayList<>();

        mockDI = Mockito.spy(new DispositivoInteligente.DispositivoInteligenteBuilder("unDI")
                .estadoDispositivo(new EstadoApagado()).build());

        mockActuador = Mockito.spy(new OrdenEncenderDI(mockDI));
        regla = new Regla(mockActuador, listaCondiciones);
        mockCondicion = Mockito.mock(CondicionPorMayor.class);
        otroMockCondicion = Mockito.mock(CondicionPorMenor.class);
        mockCondicionNoCumplida = Mockito.mock(CondicionPorIgual.class);

        Mockito.when(mockCondicion.cumpleCondicion()).thenReturn(true);
        Mockito.when(otroMockCondicion.cumpleCondicion()).thenReturn(true);
        Mockito.when(mockCondicionNoCumplida.cumpleCondicion()).thenReturn(false);
        regla.agregarCondicion(mockCondicion);
        regla.agregarCondicion(otroMockCondicion);
    }

    @Test
    public void testAgregarCondiciones() {

        regla.agregarCondicion(mockCondicionNoCumplida);
        assertEquals(3, regla.getCondicionesACumplir().size());
    }

    @Test
    public void testReglaSerNotificadaCumplenTodas() {

        regla.chequearCondicionesYEjecutar();
        assertEquals(true, mockDI.estaEncendido());
    }

    @Test
    public void testReglaSerNotificadaNoCumplenTodas() {

        regla.agregarCondicion(mockCondicionNoCumplida);
        regla.chequearCondicionesYEjecutar();
        assertEquals(false, mockDI.estaEncendido());
    }

    @Test
    public void testCumpleTodasLasCondiciones() {

        assertEquals(true, regla.cumpleTodasLasCondiciones());
    }

    @Test
    public void testNoCumpleTodasLasCondiciones() {

        regla.agregarCondicion(mockCondicionNoCumplida);
        assertEquals(false, regla.cumpleTodasLasCondiciones());
    }

}
