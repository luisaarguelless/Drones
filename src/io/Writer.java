package io;

import io.exception.WriterException;

/**
 * Created by seven4n on 4/10/16.
 */
public interface Writer<T> {

    public void write(T t) throws WriterException;
}
