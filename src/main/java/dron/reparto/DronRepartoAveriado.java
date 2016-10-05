package dron.reparto;

import casilla.Casilla;
import instruccion.Instruccion;
import io.Writer;
import io.tranformer.Transformer;

/**
 * Clase que representa un dron de reparto averiado que hace exactamente lo contrario a lo que se le
 * pide
 */

public class DronRepartoAveriado extends DronReparto {

    public DronRepartoAveriado(Casilla casilla, int pasos, Transformer transformer, Writer writer){
        super(casilla,pasos, transformer, writer);
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
