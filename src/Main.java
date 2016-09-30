import io.Reader;
import io.exception.ReaderException;

import java.util.List;

/**
 * Clase que tiene el metodo main()
 */
public class Main {
    public static void main(String[] args){
        Reader reader = new Reader("in.txt");
        try{
            List<String> lineas = reader.leerArchivo();
            lineas.forEach(System.out::println);
        }catch(ReaderException e){
            e.printStackTrace();
        }
    }
}

