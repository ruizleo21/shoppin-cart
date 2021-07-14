/**
 * 
 */
package co.com.experis.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.experis.dto.GeneralResponseDTO;
import co.com.experis.dto.ShoppingCarRequestDTO;
import co.com.experis.dto.ShoppingCarResponseDTO;
import co.com.experis.service.ShoppingCarService;

/**
 * @author leonardoruiz
 *
 */

@RestController
@RequestMapping("/shopping-cart")
@CrossOrigin("*")
public class ShoppingCarController {
	
	Logger logger = LoggerFactory.getLogger(ShoppingCarController.class);
	
	@Autowired
	ShoppingCarService shoppingCarService;
	
	@ResponseBody
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponseDTO> addProduct(@RequestBody ShoppingCarRequestDTO request ){
		logger.info("[addProduct] Entry add product with request = " + new JSONObject(request.toString()));
		ResponseEntity<GeneralResponseDTO> response = null;
		GeneralResponseDTO generalResponse = new GeneralResponseDTO(200, "The product has been added to the shopping cart");
		shoppingCarService.addProduct(request);
		response = new ResponseEntity<GeneralResponseDTO>(generalResponse, HttpStatus.OK);
		logger.info("[addProduct] The product has been added to the shopping cart");
		return response;
		
	}
	
	@ResponseBody
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ShoppingCarResponseDTO>> getProductsInCart(){
		logger.info("[getProductsInCart] Entry to get products in the shopping cart");
		ResponseEntity<List<ShoppingCarResponseDTO>> response = null;
		List<ShoppingCarResponseDTO> products = shoppingCarService.getProductsInCar();
		response = new ResponseEntity<List<ShoppingCarResponseDTO>>(products, HttpStatus.OK);
		logger.info("[getProductsInCart] The products have been returned");
		return response;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<GeneralResponseDTO> cleanShoppingCart(){
		logger.info("[cleanShoppingCart] Entry clean products in the shopping cart");
		ResponseEntity<GeneralResponseDTO> response = null;
		GeneralResponseDTO generalResponse = new GeneralResponseDTO(200, "The shopping cart has been cleaned");
		shoppingCarService.cleanShoppingCar();
		response = new ResponseEntity<GeneralResponseDTO>(generalResponse, HttpStatus.OK);
		logger.info("[cleanShoppingCart] The shopping cart has been cleaned");
		return response;
	}
	
	@PutMapping("/endShopping")
	public ResponseEntity<GeneralResponseDTO> endShopping(){
		logger.info("[endShopping] Entry end the shopping cart");
		ResponseEntity<GeneralResponseDTO> response = null;
		GeneralResponseDTO generalResponse = new GeneralResponseDTO(200, "The purchase has been finalized");
		shoppingCarService.endShopping();
		response = new ResponseEntity<GeneralResponseDTO>(generalResponse, HttpStatus.OK);
		logger.info("[endShopping] The purchase has been finalized");
		return response;
	}

}
