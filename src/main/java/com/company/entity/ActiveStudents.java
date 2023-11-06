package com.company.entity;

import com.company.entity.bace.BaceEntity;
import com.company.entity.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "students")
public class ActiveStudents extends BaceEntity {
    @Column(nullable = false)
    private String fullName;

    @OneToOne(optional = false)
    private AttachmentEntity image;

    private String degree;

    private String DescriptionUZ;
    private String DescriptionRU;
    private String DescriptionEN;
    private String DescriptionKR;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
}
