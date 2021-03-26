/**
 * 
 */
package co.com.experis.dto;

import java.io.Serializable;

/**
 * @author leonardoruiz
 *
 */
public class ShoppingCarRequestDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4117961000158528990L;
	private String productName;
	private int productAmount;
	
	/**
	 * 
	 */
	public ShoppingCarRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public String toString() {
		return "{productName:" + productName + ", productAmount:" + productAmount + "}";
	}
	
	
	

}
