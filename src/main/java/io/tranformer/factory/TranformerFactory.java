package io.tranformer.factory;


import dron.entregas.DronEntrega;
import io.tranformer.BasicTranformer;
import io.tranformer.InstruccionTranformer;
import io.tranformer.Transformer;

public class TranformerFactory {

    public static Transformer getTranformer(Object object){
        if(object instanceof DronEntrega){
            return new InstruccionTranformer();
        }
        return new BasicTranformer();
    }
}
