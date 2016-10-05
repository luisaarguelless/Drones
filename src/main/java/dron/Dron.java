package dron;


import io.exception.ReaderException;
import io.exception.WriterException;

/**
 * Interfaz que representa el comportamiento de un Dron general.
 *
 */
public interface Dron<T,V> {

    public void ejecutarInstrucciones(T t);
    public V darReporteEjecucion();


}
