package com.kuoyio.component.datajdbc;

import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class KuoyioJdbcRepository<T,ID> extends SimpleJdbcRepository<T,ID> {
    public KuoyioJdbcRepository(JdbcAggregateOperations entityOperations, PersistentEntity<T, ?> entity, JdbcConverter converter) {
        super(entityOperations, entity, converter);
    }
}
