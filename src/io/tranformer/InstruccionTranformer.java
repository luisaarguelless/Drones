package io.tranformer;

import instruccion.Instruccion;
import io.exception.ReaderException;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la transformacion de Instrucciones a
 * partir de un String
 */
public class InstruccionTranformer implements  Tranformer<List<Instruccion>,String>{

    public List<Instruccion> transform(String linea) throws ReaderException{
        String[] arrayStringInstrucciones = linea.split("");
        List<Instruccion> lineaInstrucciones =
                new ArrayList<Instruccion>();
        for(String stringInstruccion : arrayStringInstrucciones){
            lineaInstrucciones.add(
                    Instruccion.fromString(stringInstruccion));
        }
        return lineaInstrucciones;
    }
}
