package com.kuoyio.core.dto;

import java.util.List;

/**
 * 分页结果集
 *
 * @author xyz
 * @since 1.0
 */
public interface PageResponse<E> extends PageParam {
    /**
     * 总条数
     *
     * @return
     */
    long getSize();

    /**
     * 分页数据
     *
     * @return
     */
    List<E> getContent();
}
