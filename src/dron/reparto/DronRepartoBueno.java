package dron.reparto;

import casilla.Casilla;
import instruccion.Instruccion;
import io.Writer;
import io.tranformer.Transformer;

/**
 * Clase que representa los drones que entregan Domicilio.
 */
public class DronRepartoBueno extends  DronReparto{

    public DronRepartoBueno(Casilla casillaActual, int numeroPasos, Transformer tranformer, Writer writer) {
        super(casillaActual, numeroPasos, tranformer, writer);
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
