package io.transformer;

/**
 * Created by seven4n on 5/10/16.
 */
public class BasicTransformer implements Transformer<Object,Object> {

    public Object transform(Object object){
        return object;
    }
}
