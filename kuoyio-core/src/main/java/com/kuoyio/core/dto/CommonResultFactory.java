package com.kuoyio.core.dto;

import java.io.Serializable;

/**
 * @author xyz
 * @since 1.0
 */

public class CommonResultFactory {

    public static <T extends Serializable> Result<T> success(T data) {
        return new CommonResult<>(data, null, null);
    }

    public static <T extends Serializable> Result<T> error(String errorCode, String errorMsg) {
        return new CommonResult<>(null, errorCode, errorMsg);
    }

    public static <T extends Serializable> Result<T> error(T data, String errorCode, String errorMsg) {
        return new CommonResult<>(data, errorCode, errorMsg);
    }

}
