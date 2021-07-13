/**
 * 
 */
package co.com.experis.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author leonardoruiz
 *
 */
public class ProductDTO implements Serializable {

	private String name;

	private String mark;

	private double price;

	private int stock;

	private String state;

	private double discountPercentage;
}
