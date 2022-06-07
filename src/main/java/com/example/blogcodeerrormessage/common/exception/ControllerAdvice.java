package com.example.blogcodeerrormessage.common.exception;

import com.example.blogcodeerrormessage.domain.product.exception.ProductException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(ProductException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ErrorResponse handleBusinessException(final ProductException ex) {
		return new ErrorResponse(ex.getErrorcode());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ErrorResponse handleException(Exception ex) {
		return new ErrorResponse(Errorcode.UNKNOWN);
	}

	@Data
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	private static class ErrorResponse {

		private final String code;
		private final String reason;

		public ErrorResponse(final Errorcode errorcode) {
			code = errorcode.getCode();
			reason = errorcode.getReason();
		}
	}
}
