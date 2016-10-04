import casilla.CasillaPlanoCartesiano;
import casilla.Direccion;
import dron.Dron;
import dron.DronMuyBasico;
import dron.reparto.DronRepartoAveriado;
import dron.reparto.DronRepartoBueno;
import io.Writer;
import io.exception.ReaderException;
import io.exception.WriterException;
import io.Reader;
import io.reparto.FileWriter;
import io.tranformer.InstruccionTranformer;
import io.tranformer.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que tiene el metodo main()
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader("in.txt");
        Transformer tranformer = new InstruccionTranformer();

        List<Dron> listaDrones = new ArrayList<Dron>();
        listaDrones.add(new DronRepartoBueno(
                new CasillaPlanoCartesiano(0, 0, Direccion.NORTE),1,tranformer, new FileWriter("out1.txt")));
        listaDrones.add(new DronRepartoAveriado(
                new CasillaPlanoCartesiano(0,0,Direccion.NORTE),1, tranformer, new FileWriter("out2.txt")));
        listaDrones.add(new DronMuyBasico());

         try {
            List<String> lineas = reader.leerArchivo();
            for (String linea : lineas) {
                for(Dron dron: listaDrones){
                    dron.setInstrucciones(linea);
                    dron.ejecutarInstrucciones();
                }
            }
            //Dar Reporte
            for(Dron dron : listaDrones){
                 dron.darReporteEjecucion();
             }
        } catch (ReaderException e) {
            e.printStackTrace();
        } catch(WriterException e){
            e.printStackTrace();
        }
    }
}

