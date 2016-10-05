package dron.entregas;

import casilla.Casilla;
import instruccion.Instruccion;

/**
 * Clase que representa los drones que entregan Domicilio.
 */
public class DronEntregaDomicilio extends DronEntrega {

    public DronEntregaDomicilio(Casilla casillaActual, int numeroPasos) {
        super(casillaActual, numeroPasos);
    }

    @Override
    protected void ejecutarInstruccion(Instruccion instruccion){
        if(instruccion == Instruccion.AVANZAR){
            avanzar();
        }else if(instruccion == Instruccion.GIRAR_IZQUIERDA){
            girarIzquierda();
        }else if(instruccion == Instruccion.GIRAR_DERECHA){
            girarDerecha();
        }
    }




}
