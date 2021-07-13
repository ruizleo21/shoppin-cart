/**
 * 
 */
package co.com.experis.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import co.com.experis.entities.ProductEntity;
import co.com.experis.exceptions.ProductNotFoundException;
import co.com.experis.repository.ProductRespository;
import co.com.experis.service.ProductService;

/**
 * @author leonardoruiz
 *
 */
@Service
public class ProductServieImpl implements ProductService {

	private final ProductRespository productRepository;

	@Autowired
	public ProductServieImpl(ProductRespository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductEntity> getProducts() {
		List<ProductEntity> products = productRepository.findAll();
		if (products.isEmpty())
			throw new ProductNotFoundException("There are not products", 200);
		return products;
	}

	@SuppressWarnings("resource")
	@Override
	public void loadFile(String fileName) {
		String[] row = null;
		String route = "src/main/products/" + fileName;
		try {
			FileReader reader = new FileReader(route);
			CSVReader csvReader = new CSVReader(reader);
			csvReader.skip(1);
			while ((row = csvReader.readNext()) != null) {
				if (validateRow(row))
					processLine(row[0], row[1], row[2], row[3], row[4], row[5]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductEntity> getProductsByNamePriceMark(String name, double initialPrice, double endPrice,
			String mark) {
		Optional<List<ProductEntity>> products = productRepository.findAllByNamePriceMark(name.toLowerCase(), initialPrice, endPrice,
				mark.toLowerCase());
		if (products.isPresent())
			return products.get();
		throw new ProductNotFoundException("Products not found for the filters", 404);
	}

	// private methods

	private boolean validateRow(String[] row) {
		for (int i = 0; i < row.length; i++) {
			if (row[i].trim().length() == 0)
				return false;
		}
		return true;
	}

	private void processLine(String name, String mark, String price, String stock, String state, String percentage) {
		Optional<ProductEntity> product = productRepository.findById(name);
		if (product.isPresent()) {
			ProductEntity productToUpdate = product.get();
			productToUpdate.setPrice(Double.parseDouble(price));
			productToUpdate.setStock(productToUpdate.getStock() + Integer.parseInt(stock));
			productToUpdate.setDiscountPercentage(Double.parseDouble(percentage));
			productRepository.save(productToUpdate);
		} else {
			ProductEntity newProduct = new ProductEntity();
			newProduct.setName(name);
			newProduct.setMark(mark);
			newProduct.setPrice(Double.parseDouble(price));
			newProduct.setStock(Integer.valueOf(stock));
			newProduct.setState(state);
			newProduct.setDiscountPercentage(Double.parseDouble(percentage));
			productRepository.save(newProduct);
		}

	}

}
