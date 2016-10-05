package io.file;

import io.Writer;
import io.exception.WriterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase que se encarga de recibir datos del Dron y escribirlos
 */
public class FileWriter implements Writer<List<String>> {

    private final String fileName;

    public FileWriter(String fileName){
        this.fileName = fileName;
    }

    public void write(List<String> data) throws WriterException{
        try{
            Files.write(Paths.get(fileName),data);
        }catch(IOException e){
            throw new WriterException(e.getMessage(), e.getCause());
        }
    }
}
