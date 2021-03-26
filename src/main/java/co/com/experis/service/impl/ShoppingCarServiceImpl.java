/**
 * 
 */
package co.com.experis.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.experis.dto.ShoppingCarRequestDTO;
import co.com.experis.dto.ShoppingCarResponseDTO;
import co.com.experis.entities.ProductEntity;
import co.com.experis.entities.ShoppingCarEntity;
import co.com.experis.exceptions.InsufficientProductsException;
import co.com.experis.exceptions.ProductNotFoundException;
import co.com.experis.repository.ProductRespository;
import co.com.experis.repository.ShoppingCarRepository;
import co.com.experis.service.ShoppingCarService;

/**
 * @author leonardoruiz
 *
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

	private final ProductRespository productRepository;
	private final ShoppingCarRepository shoppingCarRepository;
	private final ModelMapper shoppingMapper;

	@Autowired
	public ShoppingCarServiceImpl(ProductRespository productRepository, ShoppingCarRepository shoppingCarRepository,
			ModelMapper shoppingMapper) {
		this.productRepository = productRepository;
		this.shoppingCarRepository = shoppingCarRepository;
		this.shoppingMapper = shoppingMapper;
	}

	@Override
	public void addProduct(ShoppingCarRequestDTO request) {
		Optional<ProductEntity> product = productRepository.findById(request.getProductName());
		ShoppingCarEntity shoppingCar = new ShoppingCarEntity();
		validateStockAmount(product, request.getProductAmount());
		shoppingCar.setProduct(product.get());
		Optional<ShoppingCarEntity> existingProduct = shoppingCarRepository.findByProductName(request.getProductName());
		if (existingProduct.isPresent()) {
			shoppingCar.setId(existingProduct.get().getId());
			shoppingCar.setAmount(existingProduct.get().getAmount() + request.getProductAmount());
			validateStockAmount(product, shoppingCar.getAmount());
		} else
			shoppingCar.setAmount(request.getProductAmount());
		shoppingCarRepository.save(shoppingCar);
	}

	@Override
	public List<ShoppingCarResponseDTO> getProductsInCar() {
		List<ShoppingCarEntity> products = shoppingCarRepository.findAll();
		validateShoppingCart(products);
		return products.stream().map(product -> shoppingMapper.map(product, ShoppingCarResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void cleanShoppingCar() {
		List<ShoppingCarEntity> products = shoppingCarRepository.findAll();
		validateShoppingCart(products);
		shoppingCarRepository.deleteAll();

	}

	@Override
	public void endShopping() {
		List<ShoppingCarEntity> products = shoppingCarRepository.findAll();
		validateShoppingCart(products);
		products.stream().forEach(productCart -> {
			int stock = productCart.getProduct().getStock();
			productCart.getProduct().setStock(stock - productCart.getAmount());
			productRepository.save(productCart.getProduct());
		});
		cleanShoppingCar();
	}

	private void validateStockAmount(Optional<ProductEntity> product, int amount) {
		if (!product.isPresent())
			throw new ProductNotFoundException("Product doesn't exist", 404);
		else if (product.get().getStock() <= 0)
			throw new InsufficientProductsException("No products in stock", 200);
		else if (product.get().getStock() < amount)
			throw new InsufficientProductsException("No enough products in stock", 200);
	}
	
	private void validateShoppingCart(List<ShoppingCarEntity> products) {
		if (products.isEmpty())
			throw new ProductNotFoundException("There are not products in the shopping cart", 200);
	}

}
