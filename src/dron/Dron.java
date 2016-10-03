package dron;

import instruccion.Instruccion;

import java.util.List;

/**
 * Interfaz que representa el comportamiento de un Dron general.
 *
 */
public interface Dron {

    public void ejecutarInstruccion(List<Instruccion> instrucciones);
    public String darReporteEjecucion();

}
