package io.exception;

/**
 * Excepcion que mapea los errores ocurridos al leer datos
 */
public class ReaderException extends Exception{

    public ReaderException(String message, Throwable t){
        super(message, t);
    }
}
