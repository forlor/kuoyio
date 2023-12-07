package com.kuoyio.component.datajdbc;

import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class KuoyioJdbcRepositoryImpl<T,ID> extends SimpleJdbcRepository<T,ID> implements KuoyioJdbcRepository<T,ID> {
    public KuoyioJdbcRepositoryImpl(JdbcAggregateOperations entityOperations, PersistentEntity<T, ?> entity, JdbcConverter converter) {
        super(entityOperations, entity, converter);
    }
}
