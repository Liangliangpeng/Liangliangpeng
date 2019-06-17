package com.operatormanager.api;


import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.operatormanager.pagination.ResultPage;
import com.operatormanager.pagination.YCatPage;
import com.operatormanager.utils.ObjectTools;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = -5441541734026141101L;

	private long code;

	private T data;

	private String msg;

	public R() {
	}

	public R(IErrorCode errorCode) {
		errorCode = Optional.ofNullable(errorCode).orElse(ApiErrorCode.FAILED);
		this.code = errorCode.getCode();
		this.msg = errorCode.getMsg();
	}

	public static <T> ResultPage ok(YCatPage<T> page) {
		ResultPage resultPage = new ResultPage();
		resultPage.setCode( 0 );
		resultPage.setPage(ObjectTools.toInt(page.getCurrent()));
		resultPage.setPageSize(ObjectTools.toInt(page.getSize()));
		resultPage.setTotalPages(ObjectTools.toInt(page.getPages()));
		resultPage.setTotal(page.getTotal());
		resultPage.setRows(page.getRecords());
		return resultPage;
	}

	public static <T> R<T> ok(T data) {
		ApiErrorCode aec = ApiErrorCode.SUCCESS;
		if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
			aec = ApiErrorCode.FAILED;
		}
		return restResult(data, aec);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, ApiErrorCode.FAILED.getCode(), msg);
	}

	public static <T> R<T> failed(IErrorCode errorCode) {
		return restResult(null, errorCode);
	}

	public static <T> R<T> restResult(T data, IErrorCode errorCode) {
		return restResult(data, errorCode.getCode(), errorCode.getMsg());
	}

	private static <T> R<T> restResult(T data, long code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}

	public boolean ok() {
		return ApiErrorCode.SUCCESS.getCode() == code;
	}

	public T serviceData() {
		if (!ok()) {
			throw new ApiException(this.msg);
		}
		return data;
	}
}
