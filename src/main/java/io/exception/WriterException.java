package io.exception;

/**
 * Clase que reprsenta las excepciones que ocurren al escribir el
 * resultado
 *
 * */

public class WriterException extends Exception {

    public WriterException(String message, Throwable cause){
        super(message, cause);
    }
}
