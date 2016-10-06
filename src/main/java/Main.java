import casilla.Casilla;
import casilla.CasillaPlanoCartesiano;
import casilla.Direccion;
import dron.Dron;
import dron.entregas.DronEntregaDomicilio;
import instruccion.Instruccion;
import io.Reader;
import io.Writer;
import io.exception.ReaderException;
import io.exception.WriterException;
import io.file.FileReader;
import io.file.FileWriter;
import io.transformer.Transformer;
import io.transformer.factory.TransformerFactory;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Clase que tiene el metodo main()
 */
public class Main {
    public static void main(String[] args) {
        Long momentoInicio = System.currentTimeMillis();
        //hacerEntregasSecuenciales(20);
        hacerEntregasConcurrentes(20);
        Long momentoFinal = System.currentTimeMillis();
        System.out.println("La ejecución demoró " + (momentoFinal - momentoInicio) + " milisegundos");
    }

    private static void hacerEntregasSecuenciales(Integer numeroRutasHacer){
        Casilla casillaInicial = new CasillaPlanoCartesiano(0,0,Direccion.NORTE);
        Integer velocidadDron = 1;
        IntStream.rangeClosed(1,numeroRutasHacer).forEach(index -> {
            hacerRutaDeEntregasIndividual(index, casillaInicial, velocidadDron);
        });
    }

    public static void hacerEntregasConcurrentes(Integer numeroRutasHacer){
        Casilla casillaInicial = new CasillaPlanoCartesiano(0,0,Direccion.NORTE);
        Integer velocidadDron = 1;
        IntStream.rangeClosed(1,numeroRutasHacer).parallel().forEach(index -> {
            hacerRutaDeEntregasIndividual(index, casillaInicial, velocidadDron);
        });
    }

    private static void hacerRutaDeEntregasIndividual(int numeroRuta,  Casilla casillaInicial, Integer velocidadDron ){
        try{
            Reader reader = new FileReader(getNombreArchivoEntrada(numeroRuta));
            List<String> lineas = (List<String>) reader.read();
            Dron dron = new DronEntregaDomicilio(casillaInicial, velocidadDron );
            Transformer transformer = TransformerFactory.getTranformer(dron);
            for(String lineaInstrucciones : lineas){
                List<Instruccion> instrucciones = (List<Instruccion>) transformer.transform(lineaInstrucciones);
                dron.ejecutarInstrucciones(instrucciones);
            }
            Writer writer = new FileWriter(getNombreArchivoSalida(numeroRuta));
            writer.write(dron.darReporteEjecucion());
        }catch(ReaderException e){
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }catch(WriterException e){
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    private static String completarNombreArchivos(int index){
        return (index < 10) ? "0" + index : String.valueOf(index);
    }

    private static String getNombreArchivo(String prefijo, int index){
        return prefijo + completarNombreArchivos(index) + ".txt";
    }

    private static String getNombreArchivoEntrada(int index){
        return getNombreArchivo("in" , index);
    }

    private static String getNombreArchivoSalida(int index){
        return getNombreArchivo("out", index);
    }
}

