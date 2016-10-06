package casilla;

/**
 * Interfaz que representa el comportamiento general
 * de una casilla.
 */
public interface Casilla {

    public Casilla avanzar(int pasos);
    public Casilla girarIzquierda();
    public Casilla girarDerecha();
}
