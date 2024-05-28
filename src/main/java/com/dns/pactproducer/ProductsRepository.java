package com.dns.pactproducer;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ProductsRepository {

	HashMap<Integer, ProductEntity> products = new HashMap<>();
	
	Integer id = 3;
	
	public ProductsRepository() {
		addInitialProducts();
	}
	
	private void addInitialProducts() {
		products.put(1, new ProductEntity(1, "Name1", 10));
		products.put(2, new ProductEntity(2, "Name2", 20));
		products.put(3, new ProductEntity(3, "Name3", 30));
	}


	public ProductEntity add(ProductIn productIn) {
		int nextId = Integer.MIN_VALUE;
		synchronized (this) {
			id++;
			nextId = id;
		}
		ProductEntity entity = toEntity(nextId, productIn);
		products.put(entity.getId(), entity);
		return entity;
	}
	
	public ProductEntity getById(Integer id) {
		return products.get(id);
	}
	
	public Collection<ProductEntity> getAll(){
		return products.values();
	}
	
	private ProductEntity toEntity(Integer id, ProductIn productIn) {
		return new ProductEntity(id, productIn.getName(), productIn.getPrice());
	}
	
}
