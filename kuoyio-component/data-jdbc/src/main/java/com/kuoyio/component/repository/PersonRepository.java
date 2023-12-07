package com.kuoyio.component.repository;

import com.kuoyio.component.datajdbc.KuoyioJdbcRepository;
import com.kuoyio.component.entity.Person;

/**
 * @author xyz
 * @since 1.0
 */
public interface PersonRepository extends KuoyioJdbcRepository<Person,Long> {
}
