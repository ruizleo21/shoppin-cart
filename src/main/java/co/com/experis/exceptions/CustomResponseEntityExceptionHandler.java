/**
 * 
 */
package co.com.experis.exceptions;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.experis.dto.GeneralResponseDTO;

/**
 * @author leonardoruiz
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<GeneralResponseDTO> handleProductNotFoundException(ProductNotFoundException ex){
		GeneralResponseDTO response = new GeneralResponseDTO(ex.getCode(), ex.getMessage());
		HttpStatus status = HttpStatus.valueOf(ex.getCode());
		return new ResponseEntity<GeneralResponseDTO>(response, status);
	}

	@ExceptionHandler(InsufficientProductsException.class)
	public ResponseEntity<GeneralResponseDTO> handleInsufficientProductsException(InsufficientProductsException ex){
		GeneralResponseDTO response = new GeneralResponseDTO(ex.getCode(), ex.getMessage());
		HttpStatus status = HttpStatus.valueOf(ex.getCode());
		return new ResponseEntity<GeneralResponseDTO>(response, status);
	}
}
