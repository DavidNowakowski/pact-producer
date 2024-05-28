package com.dns.pactproducer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {
	
	private final ProductsRepository repository;
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductOut> getOneById(@PathVariable("id") Integer id){
		ProductEntity productEntity = repository.getById(id);
		ProductOut productOut = toProductOut(productEntity);
		return new ResponseEntity<>(productOut, HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductOut>> getAll(){
		Collection<ProductEntity> productsEntity = repository.getAll();
		List<ProductOut> productsOut = toProductsOut(productsEntity);
		return new ResponseEntity<>(productsOut, HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<ProductOut> addProduct(@RequestBody ProductIn product){
		ProductEntity productEntity = repository.add(product);
		ProductOut productOut = toProductOut(productEntity);
		return new ResponseEntity<>(productOut, HttpStatus.CREATED);
	}
	
	private ProductOut toProductOut(ProductEntity entity) {
		return new ProductOut(entity.getId(), entity.getName(), entity.getPrice());
	}
	
	private List<ProductOut> toProductsOut(Collection<ProductEntity> productsEntities) {
		LinkedList<ProductOut> productsOut = new LinkedList<>();
		for (ProductEntity productEntity : productsEntities) {
			ProductOut productOut = toProductOut(productEntity);
			productsOut.add(productOut);
		}
		return productsOut;
	}
	
}
