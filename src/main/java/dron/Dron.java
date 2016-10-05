package dron;


import io.exception.ReaderException;
import io.exception.WriterException;

/**
 * Interfaz que representa el comportamiento de un Dron general.
 *
 */
public interface Dron {

    public void ejecutarInstrucciones();
    public void darReporteEjecucion() throws WriterException;
    public void setInstrucciones(String data) throws ReaderException;

}
