package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.Email;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "appeals")
public class Appeals extends BaceEntity {
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Lob
    @Column(columnDefinition="TEXT",nullable = false)
    private String text;
}
