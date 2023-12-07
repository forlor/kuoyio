package com.kuoyio.component.datajdbc.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.InsertOnlyProperty;

/**
 * @author xyz
 * @since 1.0
 */
public class DomainAuditable<ID, U> extends DomainBase<ID> {
    @Column("created_by")
    @InsertOnlyProperty
    @CreatedBy
    private U createdBy;
    @Column("last_modified_by")
    @LastModifiedBy
    private U lastModifiedBy;

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
