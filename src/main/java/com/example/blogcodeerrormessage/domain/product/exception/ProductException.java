package com.example.blogcodeerrormessage.domain.product.exception;

import com.example.blogcodeerrormessage.common.exception.Errorcode;
import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {

	private final Errorcode errorcode;

	public ProductException(final Errorcode errorcode) {
		super(errorcode.getReason());
		this.errorcode = errorcode;
	}
}
