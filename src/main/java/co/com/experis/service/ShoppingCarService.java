/**
 * 
 */
package co.com.experis.service;

import java.util.List;

import co.com.experis.dto.ShoppingCarRequestDTO;
import co.com.experis.dto.ShoppingCarResponseDTO;

/**
 * @author leonardoruiz
 *
 */
public interface ShoppingCarService {

	public void addProduct(ShoppingCarRequestDTO request);
	
	public List<ShoppingCarResponseDTO> getProductsInCar();
	
	public void cleanShoppingCar();
	
	public void endShopping();

}
