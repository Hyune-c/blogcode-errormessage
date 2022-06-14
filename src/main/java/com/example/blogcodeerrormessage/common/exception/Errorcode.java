package com.example.blogcodeerrormessage.common.exception;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public enum Errorcode {

	NOT_EXIST_PRODUCT,
	OUT_OF_STOCK,
	UNKNOWN,
	;

	private String code;
	private String reason;

	@RequiredArgsConstructor
	@Component
	public static class ErrorreasonInjector {

		private final ErrorcodeDataRepository repository;

		@Value("${application.locale}")
		private String locale;

		@PostConstruct
		public void postConstruct() {
			Arrays.stream(Errorcode.values())
					.forEach(errorcode ->
							repository.findByNameAndLocale(errorcode.name(), locale)
									.ifPresent(e -> {
												errorcode.code = e.getCode();
												errorcode.reason = e.getReason();
											}
									)
					);
		}
	}
}
