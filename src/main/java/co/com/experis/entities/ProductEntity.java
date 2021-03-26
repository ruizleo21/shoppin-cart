/**
 * 
 */
package co.com.experis.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author leonardoruiz
 *
 */
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7454174269849999205L;

	@Id
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String mark;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int stock;

	@Column(nullable = false)
	private String state;

	@Column(name = "discount_percentage", nullable = false)
	private double discountPercentage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<ShoppingCarEntity> shoppingCart;
	
	public ProductEntity() {

	}

	public ProductEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public List<ShoppingCarEntity> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<ShoppingCarEntity> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
