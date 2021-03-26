/**
 * 
 */
package co.com.experis.dto;

import java.io.Serializable;

/**
 * @author leonardoruiz
 *
 */
public class GeneralResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6326903216574145901L;
	
	private Integer code;
	
	private String message;

	/**
	 * @param code
	 * @param message
	 */
	public GeneralResponseDTO(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
