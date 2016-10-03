import casilla.CasillaPlanoCartesiano;
import casilla.Direccion;
import dron.Dron;
import dron.DronEntregaDomicilios;
import instruccion.Instruccion;
import io.Reader;
import io.Writer;
import io.exception.ReaderException;
import io.exception.WriterException;
import io.tranformer.InstruccionTranformer;
import io.tranformer.Tranformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que tiene el metodo main()
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader("in.txt");
        Tranformer tranformer = new InstruccionTranformer();
        Dron dron =
                new DronEntregaDomicilios(
                        new CasillaPlanoCartesiano(0, 0, Direccion.NORTE));
        List<String> resultadosEjecucion = new ArrayList<String>();
        try {
            List<String> lineas = reader.leerArchivo();
            for (String linea : lineas) {
                List<Instruccion> lineaInstrucciones =
                        (List<Instruccion>) tranformer.transform(linea);
                dron.ejecutarInstruccion(lineaInstrucciones);
                resultadosEjecucion.add(dron.darReporteEjecucion());
            }
            //Write in the file
            new Writer("out.txt").escribirArchivo(resultadosEjecucion);
        } catch (ReaderException e) {
            e.printStackTrace();
        } catch(WriterException e){
            e.printStackTrace();
        }
    }
}

