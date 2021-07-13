package co.com.experis;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.experis.service.ProductService;

@SpringBootApplication
public class ShoppingCarApplication {
	
	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCarApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

	
//	@PostConstruct
//	public void loadFile() {
//		productService.loadFile("Productos.csv");
//	}

}
