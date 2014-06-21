package com.topup.services.common.translate;

/**
 * <b>Transformer</b>
 * 
 * Transformer one object type <b>T</b> to an object <b>S</b>
 * 
 * @author alexzm1
 *
 */
public interface Transformer<T, S> {

	/**
	 * Receives an object <b>T</b> and returns an object <b>S</b>
	 * 
	 * @param source
	 *            Object <T>
	 * @return Transformed object <b>S</b>
	 */
	S transform(T source);

}
