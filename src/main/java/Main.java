import casilla.Casilla;
import casilla.CasillaPlanoCartesiano;
import casilla.Direccion;
import dron.Dron;
import dron.DronMuyBasico;
import dron.entregas.DronEntregaDomicilioAveriado;
import dron.entregas.DronEntregaDomicilio;
import io.Reader;
import io.exception.ReaderException;
import io.file.FileReader;
import io.tranformer.Transformer;
import io.tranformer.factory.TranformerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que tiene el metodo main()
 */
public class Main {
    public static void main(String[] args) {

        Reader fileReader = new FileReader("in.txt");
        Casilla casillaInicial = new CasillaPlanoCartesiano(0,0,Direccion.NORTE);
        List<Dron> listaDrones = new ArrayList<Dron>();
        listaDrones.add(new DronEntregaDomicilio(casillaInicial,1));
        listaDrones.add(new DronEntregaDomicilioAveriado(casillaInicial,1));
        listaDrones.add(new DronMuyBasico());

         try {
            List<String> lineas =(List<String>) fileReader.read();
            for (String linea : lineas) {
                for(Dron dron: listaDrones){
                    Transformer tranformer = TranformerFactory.getTranformer(dron);
                    dron.ejecutarInstrucciones(tranformer.transform(linea));
                }
            }
            //Dar Reporte
            for(Dron dron : listaDrones){
                System.out.println( dron.darReporteEjecucion());
            }
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }
}

