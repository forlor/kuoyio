package com.kuoyio.core.dto;

/**
 * @author xyz
 * @since 1.0
 */
public interface PageParam {
    /**
     * 页码
     * @return
     */
    int getPageNumber();

    /**
     * 页大小，即一页的行数
     * @return
     */
    int getPageSize();
}
