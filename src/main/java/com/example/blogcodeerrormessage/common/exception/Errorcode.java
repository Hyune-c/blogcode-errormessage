package com.example.blogcodeerrormessage.common.exception;

import java.util.Arrays;
import java.util.Locale;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public enum Errorcode {

	NOT_EXIST_PRODUCT("1001", "product.not_exist_product"),
	OUT_OF_STOCK("1200", "product.out_of_stock"),
	UNKNOWN("9999", "product.unknown"),
	;

	private final String code;
	private final String propertiesCode;
	private String reason;

	@RequiredArgsConstructor
	@Component
	public static class ErrorreasonInjector {

		private final MessageSource messageSource;

		@Value("${application.locale}")
		private String locale;

		@PostConstruct
		public void postConstruct() {
			Arrays.stream(Errorcode.values())
					.forEach(errorcode -> errorcode.reason = messageSource.getMessage(errorcode.getPropertiesCode(), null, Locale.forLanguageTag(this.locale)));
		}
	}
}
