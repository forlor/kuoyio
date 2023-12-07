package com.kuoyio.component.datajdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xyz
 * @since 1.0
 */
public class DomainBase<ID> implements Serializable {
    @Id
    private ID id;
    @Column("create_time")
    private LocalDateTime createTime;
    @Column("last_modified_time")
    private LocalDateTime lastModifiedTime;
    /**
     * 版本字段为null或0时，将当作新对象进行持久化。反之将会视为update操作
     *
     * @see <a href='https://docs.spring.io/spring-data/relational/reference/repositories/core-concepts.html#is-new-state-detection'>is-new-state-detection</a>
     */
    @Version
    @Column("version")
    private Integer version;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
