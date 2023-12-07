package com.kuoyio.component.datajdbc.domain;

import org.springframework.data.relational.core.mapping.Column;

/**
 * @author xyz
 * @since 1.0
 */
public class DomainAuditable<ID, U> extends DomainBase<ID> {
    @Column("created_by")
    private U createdBy;
    @Column("last_modified_by")
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
