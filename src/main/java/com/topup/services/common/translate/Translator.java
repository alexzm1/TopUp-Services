package com.topup.services.common.translate;

/**
 * <b>Translator</b>
 * 
 * Translate one object type <b>T</b> to an object <b>S</b>
 * 
 * @author alexzm1
 *
 */
public interface Translator<T, S> {

	/**
	 * Receives an object <b>T</b> and returns an object <b>S</b>
	 * 
	 * @param source
	 *            Object <T>
	 * @return Translation of object to object <b>S</b>
	 */
	S translate(T source);

}
