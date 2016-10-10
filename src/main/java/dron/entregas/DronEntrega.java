package dron.entregas;

import casilla.Casilla;
import dron.Dron;
import instruccion.Instruccion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un Dron de reparto
 */
public abstract  class DronEntrega implements Dron<List<Instruccion>, List<String>>{

    private Casilla casillaActual;
    private final Integer velocidadDron;
    private List<String> listaResultadosEjecucion = new ArrayList<String>();

    public DronEntrega(Casilla casillaActual, Integer velocidadDron)
            throws IllegalArgumentException{
        if(velocidadDron < 0)
            throw  new IllegalArgumentException("El número de pasos que da el Dron de reparto debe ser mayor a cero");
        this.casillaActual = casillaActual;
        this.velocidadDron = velocidadDron;
    }

    public Casilla getCasillaActual(){
        return this.casillaActual;
    }


    public int getPasos(){
        return velocidadDron;
    }

    protected void guardarResultadoEjecucion(){
        listaResultadosEjecucion.add(casillaActual.toString());
    }

    public List<String> darReporteEjecucion(){
        return listaResultadosEjecucion;
    }

    protected void avanzar(){
        this.casillaActual = casillaActual.avanzar(velocidadDron);
    }

    protected  void retroceder(){
        this.casillaActual = casillaActual.avanzar(-velocidadDron);
    }

    protected  void girarIzquierda(){
        this.casillaActual = casillaActual.girarIzquierda();
    }

    protected  void  girarDerecha(){
        this.casillaActual = casillaActual.girarDerecha();
    }

}
