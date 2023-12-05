package com.kuoyio.core.dto;

import java.io.Serializable;

/**
 * 结果对象的抽象
 *
 * @author xyz
 * @since 1.0
 */
public interface Result<T> {
    /**
     * 结果数据
     *
     * @return 结果
     */
    T getData();

    void setData(T data);
    /**
     * 异常code码
     *
     * @return 异常code码
     */
    String getErrorCode();

    void setErrorCode(String errorCode);
    /**
     * 异常消息，可以直接展示的信息
     *
     * @return 异常信息
     */
    String getErrorMsg();

    void setErrorMsg(String errorMsg);

}
