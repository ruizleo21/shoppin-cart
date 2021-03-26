/**
 * 
 */
package co.com.experis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.experis.entities.ShoppingCarEntity;

/**
 * @author leonardoruiz
 *
 */
public interface ShoppingCarRepository extends JpaRepository<ShoppingCarEntity, Integer> {
	@Query("from ShoppingCarEntity where product.name = :productName")
	public Optional<ShoppingCarEntity> findByProductName(@Param(value = "productName") String productName);
}
