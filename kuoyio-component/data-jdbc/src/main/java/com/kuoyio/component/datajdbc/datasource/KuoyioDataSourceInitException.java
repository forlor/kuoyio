package com.kuoyio.component.datajdbc.datasource;

import com.kuoyio.core.exception.BaseException;


/**
 * 数据源构建初始化exception
 *
 * @author xyz
 * @since 1.0
 */

public class KuoyioDataSourceInitException extends BaseException {
    public KuoyioDataSourceInitException(String errMessage) {
        super(errMessage);
    }

    public KuoyioDataSourceInitException(String errMessage, Throwable e) {
        super(errMessage, e);
    }
}
