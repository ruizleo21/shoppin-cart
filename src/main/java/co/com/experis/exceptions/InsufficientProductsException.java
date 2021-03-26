/**
 * 
 */
package co.com.experis.exceptions;

/**
 * @author leonardoruiz
 *
 */
public class InsufficientProductsException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8636664071486198943L;

	public InsufficientProductsException(String message, Integer code) {
		super(message, code);
	}

}
