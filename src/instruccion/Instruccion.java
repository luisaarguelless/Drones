package instruccion;

import io.exception.ReaderException;

/**
 * Enum que representa las distintas instrucciones que puede ejecutar un Dron
 */
public enum Instruccion {
    AVANZAR("A"),
    GIRAR_IZQUIERDA("I"),
    GIRAR_DERECHA("D");

    private final String descripcion;
    Instruccion(String descripcion){
        this.descripcion = descripcion;
    }

    public static Instruccion fromString(String s)
            throws ReaderException {
        for (Instruccion instruccion : Instruccion.values()) {
            if (instruccion.descripcion.equals(s))
                return instruccion;
        }
        throw new ReaderException("Instruccion no válida",
                new IllegalArgumentException());
    }
}
