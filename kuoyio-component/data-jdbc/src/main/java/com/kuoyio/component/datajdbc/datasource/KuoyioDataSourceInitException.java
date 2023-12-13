package com.kuoyio.component.datajdbc.datasource;

import com.kuoyio.core.exception.BaseException;


/**
 * @author xyz
 * @since 1.0
 */

public class KuoyioDataSourceInitException extends BaseException {

    public KuoyioDataSourceInitException(String errMessage, Throwable e) {
        super(errMessage, e);
    }
}
