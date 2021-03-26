/**
 * 
 */
package co.com.experis.exceptions;

/**
 * @author leonardoruiz
 *
 */
public class ProductNotFoundException extends BusinessException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3953126865934091126L;

	public ProductNotFoundException(String message, Integer code) {
		super(message, code);
	}

}
