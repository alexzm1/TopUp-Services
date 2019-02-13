package com.topup.services.common.translate;

/**
 * <b>Transformer</b>
 * <p>
 * Transformer one object type <b>T</b> to an object <b>S</b>
 *
 * @param <T> Input object
 * @param <S> Output object
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public interface Transformer<T, S> {

    /**
     * Receives an object <b>T</b> and returns an object <b>S</b>
     *
     * @param source Object <T>
     * @return Transformed object <b>S</b>
     */
    S transform(T source);

}
