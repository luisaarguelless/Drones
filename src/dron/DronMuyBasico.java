package dron;

import io.exception.ReaderException;

/**
 * Created by seven4n on 4/10/16.
 */
public class DronMuyBasico implements Dron{

    private String instruccion;

    public void setInstrucciones(String data) throws ReaderException{
        this.instruccion = data;
    }

    public void ejecutarInstrucciones(){
        System.out.println("Instrucción ejecutada con exito: " + instruccion.toLowerCase());
    }

    public void darReporteEjecucion(){
        System.out.println("Soy un dron muy básico y no tengo nada que reportar " + this.getClass());
    }
}
