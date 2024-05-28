package com.dns.pactproducer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	private Integer id;
	
	private String name;
	
	private Integer price;
}
