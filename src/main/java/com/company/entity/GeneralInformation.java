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
@Entity(name = "general_information")
public class GeneralInformation extends BaceEntity {

    @Column(nullable = false)
    private int StudentsNumber;
    @Column(nullable = false)
    private int ProffessorNumber;
    @Column(nullable = false)
    private int DoktorantNumber;
    @Column(nullable = false)
    private int independentResearchersNumber;
    @Column(nullable = false)
    private int AuditoriumNumber;
    @Column(nullable = false)
    private int JointTrainingNumber;
    @Column(nullable = false)
    private int FieldsofStudyNumber;
    @Column(nullable = false)
    private int FacultyNumber;



}
