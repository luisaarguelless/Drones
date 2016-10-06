package io.file;

import io.Reader;
import io.exception.ReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Clase que se encarga de leer datos y pasarlos al Dron
 */
public class FileReader implements Reader<List<String>> {

    private final String fileName;

    public FileReader(String fileName){
        this.fileName = fileName;
    }

    public List<String> read() throws ReaderException{
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            List<String> lineas = new ArrayList();
            stream.forEach(lineas::add);
            System.out.println("Leyendo el archivo " + fileName);
            return lineas;
        }catch(IOException ex){
            System.out.println("Excepcion leyendo el archivo " + fileName);
            ex.printStackTrace();
            throw  new ReaderException(ex.getMessage(), ex.getCause());
        }
    }
}
