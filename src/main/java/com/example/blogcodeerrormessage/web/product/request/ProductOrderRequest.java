package com.example.blogcodeerrormessage.web.product.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOrderRequest {

	private Long id;
	private Integer quantity;
}
