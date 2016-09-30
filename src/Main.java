import instruccion.Instruccion;
import io.Reader;
import io.exception.ReaderException;
import io.tranformer.InstruccionTranformer;
import io.tranformer.Tranformer;

import java.util.List;

/**
 * Clase que tiene el metodo main()
 */
public class Main {
    public static void main(String[] args){
        Reader reader = new Reader("in.txt");
        Tranformer tranformer = new InstruccionTranformer();
        try{
            List<String> lineas = reader.leerArchivo();
            for(String linea: lineas){
                List<Instruccion> lineaInstrucciones =
                        (List<Instruccion>) tranformer.transform(linea);
                System.out.println(lineaInstrucciones);
            }

        }catch(ReaderException e){
            e.printStackTrace();
        }
    }
}

