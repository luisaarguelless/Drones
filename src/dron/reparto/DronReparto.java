package dron.reparto;

import casilla.Casilla;
import dron.Dron;
import instruccion.Instruccion;
import io.Writer;
import io.exception.ReaderException;
import io.exception.WriterException;
import io.tranformer.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un Dron de reparto
 */
public abstract  class DronReparto implements Dron{

    private Casilla casillaActual;
    private final int numeroDePasos;
    private List<Instruccion> instrucciones = new ArrayList<>();
    private List<String> listaResultadosEjecucion = new ArrayList<String>();
    private Transformer tranformer ;
    private Writer writer;


    @Override
    public void setInstrucciones(String data) throws ReaderException{
           this.instrucciones = (List<Instruccion>) tranformer.transform(data);
    }

    protected List<Instruccion> getInstrucciones(){ return instrucciones;}

    public DronReparto(Casilla casillaActual, int numeroDePasos, Transformer tranformer, Writer writer)
            throws IllegalArgumentException{
        if(numeroDePasos < 0)
            throw  new IllegalArgumentException("El número de pasos que da el Dron de reparto debe ser mayor a cero");
        this.casillaActual = casillaActual;
        this.numeroDePasos = numeroDePasos;
        this.tranformer = tranformer;
        this.writer = writer;
    }

    public Casilla getCasillaActual(){
        return this.casillaActual;
    }


    public int getPasos(){
        return numeroDePasos;
    }

    public void darReporteEjecucion() throws WriterException{
        writer.write(listaResultadosEjecucion);
    }

    @Override
    public void ejecutarInstrucciones(){
        for(Instruccion instruccion: instrucciones){
            ejecutarInstruccion(instruccion);
        }
        listaResultadosEjecucion.add(casillaActual.toString());
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
