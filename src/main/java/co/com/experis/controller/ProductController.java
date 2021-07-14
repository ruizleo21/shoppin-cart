/**
 * 
 */
package co.com.experis.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.experis.dto.GeneralResponseDTO;
import co.com.experis.entities.ProductEntity;
import co.com.experis.service.ProductService;

/**
 * @author leonardoruiz
 *
 */
@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@ResponseBody
	@GetMapping(value = "/")
	public ResponseEntity<List<ProductEntity>> getProducts() {
		logger.info("[getProducts] Entry to get products");
		ResponseEntity<List<ProductEntity>> response = null;
		List<ProductEntity> products = new ArrayList<>();
		products = productService.getProducts();
		response = new ResponseEntity<List<ProductEntity>>(products, HttpStatus.OK);
		logger.info("[getProducts] The products have been returned");
		return response;
	}

	@GetMapping(value = "/loadfile")
	public ResponseEntity<GeneralResponseDTO> loadFile(@RequestParam String fileName) {
		logger.info("[loadFile] Entry to load file wit name: " + fileName);
		ResponseEntity<GeneralResponseDTO> response = null;
		GeneralResponseDTO generalResponse = new GeneralResponseDTO(200, "The file has been loaded");
		productService.loadFile(fileName);
		response = new ResponseEntity<GeneralResponseDTO>(generalResponse, HttpStatus.OK);
		logger.info("[loadFile] The file has been loaded");
		return response;
	}

	@ResponseBody
	@GetMapping(value = "/filters", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductEntity>> getProductsByNamePriceMark(@RequestParam String name,
			@RequestParam double initialPrice, @RequestParam double endPrice, @RequestParam String mark) {
		logger.info(String.format(
				"[getProductsByNamePriceMark] Entry to get product, by the next filters. Name: %s, InitialPrice: %s, EndPrice: %s and Mark: %s",
				name, initialPrice, endPrice, mark));
		ResponseEntity<List<ProductEntity>> response = null;
		List<ProductEntity> products = new ArrayList<>();
		products = productService.getProductsByNamePriceMark(name, initialPrice, endPrice, mark);
		response = new ResponseEntity<List<ProductEntity>>(products, HttpStatus.OK);
		logger.info("[getProductsByNamePriceMark] The products have been returned");
		return response;
	}

}
