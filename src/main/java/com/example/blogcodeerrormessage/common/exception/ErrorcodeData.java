package com.example.blogcodeerrormessage.common.exception;

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
public class ErrorcodeData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String locale;
	private String name;
	private String code;
	private String reason;

	public ErrorcodeData(final String name, final String code, final String reason) {
		this.name = name;
		this.code = code;
		this.reason = reason;
	}

	public static ErrorcodeData unknown() {
		return new ErrorcodeData("UNKNOWN", "9999", "UNKNOWN");
	}
}
