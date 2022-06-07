package com.example.blogcodeerrormessage.common;

import com.example.blogcodeerrormessage.domain.product.entity.Product;
import com.example.blogcodeerrormessage.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class InitDataConfiguration {

	private final ProductRepository productRepository;

	@Bean
	public void initData() {
		final Product product = new Product("식용유", 3);
		productRepository.save(product);
	}
}
