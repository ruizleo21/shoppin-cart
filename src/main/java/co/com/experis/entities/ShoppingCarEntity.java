/**
 * 
 */
package co.com.experis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author leonardoruiz
 *
 */
@Entity
@Table(name = "shopping_car")
public class ShoppingCarEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7311511931374709873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private int amount;
	
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name="name", nullable = false)
	private ProductEntity product;

	/**
	 * 
	 */
	public ShoppingCarEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	
	
	

}
