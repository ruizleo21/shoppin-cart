/**
 * 
 */
package co.com.experis.dto;

import java.io.Serializable;

/**
 * @author leonardoruiz
 *
 */
public class ShoppingCarResponseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3630622129059469372L;

	private Integer id;
	
	private Integer amount;
	
	private String nameProduct;

	/**
	 * 
	 */
	public ShoppingCarResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	

}
