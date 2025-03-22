package com.techgel.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "roles")
public class Role extends BasedEntity{
    @Column(length = 40, nullable = false, unique = true)
    private String name;

    @Column(length = 150)
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
