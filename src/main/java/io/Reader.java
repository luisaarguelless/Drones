package io;

import io.exception.ReaderException;

/**
 * Created by seven4n on 5/10/16.
 */
public interface Reader<T> {

    public T read() throws ReaderException;
}
