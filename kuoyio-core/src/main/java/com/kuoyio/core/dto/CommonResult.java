package com.kuoyio.core.dto;

import java.io.Serializable;

/**
 * @author xyz
 * @since 1.0
 */

class CommonResult<T> implements Result<T>, Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private String errorCode;
    private String errorMsg;

    CommonResult() {
    }

    CommonResult(T data, String errorCode, String errorMsg) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
