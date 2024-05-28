package com.dns.pactproducer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOut {
	
	private Integer id;
	
	private String name;
	
	private Integer price;

}
