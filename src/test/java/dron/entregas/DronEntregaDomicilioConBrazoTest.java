package dron.entregas;

import casilla.Casilla;
import casilla.CasillaPlanoCartesiano;
import casilla.Direccion;
import instruccion.Instruccion;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Pruebas unitarias del DronEntregaDomicilioConBrazo
 */
public class DronEntregaDomicilioConBrazoTest {

    @Test
    public void ejecutarInstrucciones(){
        Integer coordenadaXOriginal = 0;
        Integer coordenadaYOriginal = 0;
        Direccion direccionOriginal = Direccion.NORTE;
        Integer velocidadDron = 1;
        Casilla casillaPartida = new CasillaPlanoCartesiano(coordenadaXOriginal, coordenadaYOriginal, direccionOriginal);
        DronEntrega dron = new DronEntregaDomicilioConBrazo(casillaPartida, velocidadDron);
        //AAAAIAAD
        List<Instruccion> instrucciones = Arrays.asList(
                Instruccion.AVANZAR,
                Instruccion.AVANZAR,
                Instruccion.AVANZAR,
                Instruccion.AVANZAR,
                Instruccion.GIRAR_IZQUIERDA,
                Instruccion.AVANZAR,
                Instruccion.AVANZAR,
                Instruccion.GIRAR_DERECHA);
        Casilla casillaEntrega = new CasillaPlanoCartesiano(-2,4,Direccion.NORTE);
        List<String> resultadosEjecucionEsperados = Arrays.asList(casillaEntrega.toString());
        dron.ejecutarInstrucciones(instrucciones);
        assertEquals(resultadosEjecucionEsperados, dron.darReporteEjecucion());
        assertEquals(casillaPartida.toString(), dron.getCasillaActual().toString());
    }
}