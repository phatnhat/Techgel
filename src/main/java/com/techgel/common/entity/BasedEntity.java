package com.techgel.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class BasedEntity extends IdBasedEntity implements Serializable{
    @Transient
    public static final Sort SORT_BY_CREATED_AT_DESC =
            Sort.by(Sort.Direction.DESC, "createdAt");

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    public BasedEntity(Long id) {
        this.id = id;
    }
}