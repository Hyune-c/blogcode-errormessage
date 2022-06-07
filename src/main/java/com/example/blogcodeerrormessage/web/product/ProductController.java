package com.example.blogcodeerrormessage.web.product;

import com.example.blogcodeerrormessage.domain.product.service.ProductService;
import com.example.blogcodeerrormessage.web.product.request.ProductOrderRequest;
import com.example.blogcodeerrormessage.web.product.request.ProductStockupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController {

	private final ProductService productService;

	@PostMapping("/api/product/order")
	public void order(@RequestBody final ProductOrderRequest request) {
		productService.order(request.getId(), request.getQuantity());
	}

	@PostMapping("/api/product/stockup")
	public Integer stockup(@RequestBody final ProductStockupRequest request) {
		return productService.stockup(request.getId(), request.getQuantity());
	}
}
