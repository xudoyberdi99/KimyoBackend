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

    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private AttachmentEntity image;

    private String degree;

    private String directionUZ;
    private String directionRU;
    private String directionEN;
    private String directionKR;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String DescriptionUZ;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String DescriptionRU;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String DescriptionEN;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String DescriptionKR;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @ManyToOne(optional = false)
    private Category category;
}
