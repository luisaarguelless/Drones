package io.transformer.factory;


import dron.entregas.DronEntrega;
import io.transformer.BasicTransformer;
import io.transformer.InstruccionTransformer;
import io.transformer.Transformer;

public class TransformerFactory {

    public static Transformer getTranformer(Object object){
        if(object instanceof DronEntrega){
            return new InstruccionTransformer();
        }
        return new BasicTransformer();
    }
}
