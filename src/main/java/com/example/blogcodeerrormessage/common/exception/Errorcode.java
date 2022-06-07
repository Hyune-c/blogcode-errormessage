package com.example.blogcodeerrormessage.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errorcode {

	NOT_EXIST_PRODUCT("1001", "대상 상품 없음"),
	OUT_OF_STOCK("1200", "상품 재고 없음"),
	UNKNOWN("9999", "알 수 없는 에러"),
	;

	private final String code;
	private final String reason;
}
