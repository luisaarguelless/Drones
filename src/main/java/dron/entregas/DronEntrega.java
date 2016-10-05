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
    private final int numeroDePasos;
    private List<String> listaResultadosEjecucion = new ArrayList<String>();

    public DronEntrega(Casilla casillaActual, int numeroDePasos)
            throws IllegalArgumentException{
        if(numeroDePasos < 0)
            throw  new IllegalArgumentException("El número de pasos que da el Dron de reparto debe ser mayor a cero");
        this.casillaActual = casillaActual;
        this.numeroDePasos = numeroDePasos;
    }

    public Casilla getCasillaActual(){
        return this.casillaActual;
    }


    public int getPasos(){
        return numeroDePasos;
    }



    @Override
    public void ejecutarInstrucciones(List<Instruccion> instrucciones){
        for(Instruccion instruccion: instrucciones){
            ejecutarInstruccion(instruccion);
        }
        listaResultadosEjecucion.add(casillaActual.toString());
    }

    @Override
    public List<String> darReporteEjecucion(){
        return this.listaResultadosEjecucion;
    }

    protected abstract void ejecutarInstruccion(Instruccion instruccion);

    protected void avanzar(){
        this.casillaActual = casillaActual.avanzar(numeroDePasos);
    }

    protected  void retroceder(){
        this.casillaActual = casillaActual.avanzar(-numeroDePasos);
    }

    protected  void girarIzquierda(){
        this.casillaActual = casillaActual.girarIzquierda();
    }

    protected  void  girarDerecha(){
        this.casillaActual = casillaActual.girarDerecha();
    }

}
