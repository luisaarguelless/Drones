package io;

import io.exception.WriterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase que se encarga de recibir datos del Dron y escribirlos
 */
public class Writer {

    private final String fileName;

    public Writer(String fileName){
        this.fileName = fileName;
    }

    public void escribirArchivo(List<String> data) throws WriterException{
        try{
            Files.write(Paths.get(fileName),data);
        }catch(IOException e){
            throw new WriterException(e.getMessage(), e.getCause());
        }
    }
}
