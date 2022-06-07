package com.example.blogcodeerrormessage.domain.product.entity;

import com.example.blogcodeerrormessage.common.exception.Errorcode;
import com.example.blogcodeerrormessage.domain.product.exception.ProductException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer quantity;

	public Product(final String name, final Integer quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public void order(final Integer quantity) {
		if (this.quantity < quantity) {
			throw new ProductException(Errorcode.OUT_OF_STOCK);
		}

		this.quantity -= quantity;
	}

	public Integer stockup(final Integer quantity) {
		this.quantity += quantity;
		return this.quantity;
	}
}
