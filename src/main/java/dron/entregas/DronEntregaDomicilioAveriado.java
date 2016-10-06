package dron.entregas;

import casilla.Casilla;
import instruccion.Instruccion;

/**
 * Clase que representa un dron de reparto averiado que hace exactamente lo contrario a lo que se le
 * pide
 */

public class DronEntregaDomicilioAveriado extends DronEntrega {

    public DronEntregaDomicilioAveriado(Casilla casilla, int pasos){
        super(casilla,pasos);
    }

    @Override
    protected void ejecutarInstruccion(Instruccion instruccion){
        if(instruccion == Instruccion.AVANZAR){
            retroceder();
        }else if(instruccion == Instruccion.GIRAR_IZQUIERDA){
            girarDerecha();
        }else if(instruccion == Instruccion.GIRAR_DERECHA){
            girarIzquierda();
        }
    }
}
