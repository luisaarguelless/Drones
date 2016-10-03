package dron;

import casilla.Casilla;
import instruccion.Instruccion;

import java.util.List;

/**
 * Clase que representa los drones que entregan Domicilio.
 */
public class DronEntregaDomicilios implements  Dron {

    private Casilla casillaActual;

    public DronEntregaDomicilios(Casilla casillaActual){
        this.casillaActual = casillaActual;
    }

    public void ejecutarInstruccion(List<Instruccion> instrucciones){
        for(Instruccion instruccion: instrucciones){
            if(instruccion == Instruccion.AVANZAR){
                casillaActual = casillaActual.avanzar();
            }else if(instruccion == Instruccion.GIRAR_IZQUIERDA){
                casillaActual = casillaActual.girarIzquierda();
            }else if(instruccion == Instruccion.GIRAR_DERECHA){
                casillaActual = casillaActual.girarDerecha();
            }
        }
    }

    public String darReporteEjecucion(){
       return casillaActual.toString();
    }
}
