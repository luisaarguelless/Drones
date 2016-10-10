package dron.entregas;


import casilla.Casilla;
import instruccion.Instruccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class DronEntregaDomicilioConBrazo extends DronEntrega {

    public DronEntregaDomicilioConBrazo(Casilla casilla, Integer velocidadDron){
        super(casilla, velocidadDron);
    }

    @Override
    public void  ejecutarInstrucciones(List<Instruccion> instrucciones){
        for(Instruccion instruccion: instrucciones){
            ejecutarInstruccion(instruccion);
        }
        guardarResultadoEjecucion();
        ejecutarInsruccionesContrarias(instrucciones);
    }

    private void ejecutarInsruccionesContrarias(List<Instruccion> instrucciones){
        List<Instruccion> instruccionesContrarias = invertirInstrucciones(instrucciones);
        for(Instruccion instruccion : instruccionesContrarias){
            ejecutarInstruccionContraria(instruccion);
        }
    }

    private List<Instruccion> invertirInstrucciones(List<Instruccion> instruccionesOriginales){
        List<Instruccion> instruccionesContrarias = new ArrayList<>(instruccionesOriginales);
        Collections.reverse(instruccionesContrarias);
        return instruccionesContrarias;
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

    private void ejecutarInstruccionContraria(Instruccion instruccion){
        if(instruccion == Instruccion.AVANZAR){
            retroceder();
        }else if(instruccion == Instruccion.GIRAR_IZQUIERDA){
            girarDerecha();
        }else if(instruccion == Instruccion.GIRAR_DERECHA){
            girarIzquierda();
        }
    }
}

