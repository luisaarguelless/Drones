package io.tranformer;

import io.exception.ReaderException;

/**
 *
 * @param <T> Tipo de dato de Salida
 * @param <V> Tipo de dato de Entrada
 */
public interface Tranformer<T,V> {

    public T transform(V entrada) throws ReaderException;
}
