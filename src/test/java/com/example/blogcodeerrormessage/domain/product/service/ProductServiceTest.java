package com.example.blogcodeerrormessage.domain.product.service;

import static org.assertj.core.api.Assertions.*;

import com.example.blogcodeerrormessage.common.exception.Errorcode;
import com.example.blogcodeerrormessage.domain.product.entity.Product;
import com.example.blogcodeerrormessage.domain.product.exception.ProductException;
import com.example.blogcodeerrormessage.domain.product.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@DisplayName("재고 부족 예외 처리")
	@Test
	void outOfStock() {
		// given
		final Product product = new Product("식용유", 2);
		productRepository.save(product);
		final Long id = product.getId();

		productService.order(id, 1);
		productService.order(id, 1);

		// when
		assertThatThrownBy(() -> productService.order(id, 1))
				.isInstanceOf(ProductException.class)
				.hasMessage(Errorcode.OUT_OF_STOCK.getReason())
				.hasMessage("상품 재고 없음");
	}
}
