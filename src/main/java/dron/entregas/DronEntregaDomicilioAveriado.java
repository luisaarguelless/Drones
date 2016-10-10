package dron.entregas;

import casilla.Casilla;
import instruccion.Instruccion;

import java.util.List;

/**
 * Clase que representa un dron de reparto averiado que hace exactamente lo contrario a lo que se le
 * pide
 */

public class DronEntregaDomicilioAveriado extends DronEntrega {

    public DronEntregaDomicilioAveriado(Casilla casilla, Integer velocidadDron){
        super(casilla,velocidadDron);
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
            retroceder();
        }else if(instruccion == Instruccion.GIRAR_IZQUIERDA){
            girarDerecha();
        }else if(instruccion == Instruccion.GIRAR_DERECHA){
            girarIzquierda();
        }
    }
}
