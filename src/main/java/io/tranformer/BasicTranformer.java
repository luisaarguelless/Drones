package io.tranformer;

/**
 * Created by seven4n on 5/10/16.
 */
public class BasicTranformer implements Transformer<Object,Object> {

    public Object transform(Object object){
        return object;
    }
}
