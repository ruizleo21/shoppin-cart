/**
 * 
 */
package co.com.experis.service;

import java.util.List;

import co.com.experis.entities.ProductEntity;

/**
 * @author leonardoruiz
 *
 */
public interface ProductService {
	public List<ProductEntity>  getProducts();
	
	public void loadFile(String fileName);
	
	public List<ProductEntity> getProductsByNamePriceMark(String name, double initialPrice, double endPrice, String mark);

}
