/**
 * 
 */
package co.com.experis.exceptions;

/**
 * @author leonardoruiz
 *
 */
public class BusinessException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4678319507778732465L;
	private final Integer code;

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

	public Integer getCode() {
		return code;
	}
    
    
}

