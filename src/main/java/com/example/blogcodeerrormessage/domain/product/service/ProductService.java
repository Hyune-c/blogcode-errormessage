package com.example.blogcodeerrormessage.domain.product.service;

import com.example.blogcodeerrormessage.common.exception.Errorcode;
import com.example.blogcodeerrormessage.domain.product.entity.Product;
import com.example.blogcodeerrormessage.domain.product.exception.ProductException;
import com.example.blogcodeerrormessage.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public void order(final Long id, final Integer quantity) {
		final Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductException(Errorcode.NOT_EXIST_PRODUCT));
		product.order(quantity);
	}

	public Integer stockup(final Long id, final Integer quantity) {
		final Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductException(Errorcode.NOT_EXIST_PRODUCT));
		return product.stockup(quantity);
	}
}
