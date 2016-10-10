package dron.entregas;

import casilla.Casilla;
import instruccion.Instruccion;

import java.util.List;

/**
 * Clase que representa los drones que entregan Domicilio.
 */
public class DronEntregaDomicilio extends DronEntrega {

    public DronEntregaDomicilio(Casilla casillaActual, Integer velocidadDron) {
        super(casillaActual, velocidadDron);
    }

    @Override
    public void ejecutarInstrucciones(List<Instruccion> instrucciones){
        for(Instruccion instruccion: instrucciones){
            ejecutarInstruccion(instruccion);
        }
        guardarResultadoEjecucion();
    }

    private void ejecutarInstruccion(Instruccion instruccion){
        if(instruccion == Instruccion.AVANZAR){
            avanzar();
        }else if(instruccion == Instruccion.GIRAR_IZQUIERDA){
            girarIzquierda();
        }else if(instruccion == Instruccion.GIRAR_DERECHA){
            girarDerecha();
        }
    }




}
