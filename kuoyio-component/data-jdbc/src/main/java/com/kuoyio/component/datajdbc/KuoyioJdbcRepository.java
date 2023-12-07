package com.kuoyio.component.datajdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author xyz
 * @since 1.0
 */
@NoRepositoryBean
public interface KuoyioJdbcRepository<T, ID> extends CrudRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}
