/**
 * 
 */
package co.com.experis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.experis.entities.ProductEntity;

/**
 * @author leonardoruiz
 *
 */
@Repository
public interface ProductRespository extends JpaRepository<ProductEntity, String> {
	@Query("from ProductEntity where lower(name) like %:name% or price between :initialPrice and :endPrice or lower(mark) = :mark")
	Optional<List<ProductEntity>> findAllByNamePriceMark(@Param("name") String name,
			@Param("initialPrice") double initialPrice, @Param("endPrice") double endPrice, @Param("mark") String mark);

}
