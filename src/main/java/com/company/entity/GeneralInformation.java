package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "information")
public class GeneralInformation extends BaceEntity {
    @Column(nullable = false)
    private int studentsNumber;
    @Column(nullable = false)
    private int proffessorNumber;
    @Column(nullable = false)
    private int doktorantNumber;
    @Column(nullable = false)
    private int independentResearchersNumber;
    @Column(nullable = false)
    private int auditoriumNumber;
    @Column(nullable = false)
    private int jointTrainingNumber;
    @Column(nullable = false)
    private int fieldsofStudyNumber;
    @Column(nullable = false)
    private int facultyNumber;
}
