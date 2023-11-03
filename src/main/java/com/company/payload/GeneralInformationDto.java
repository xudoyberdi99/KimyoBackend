package com.company.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GeneralInformationDto {

    @NotNull(message = "StudentsNumber ni kiriting")
    private int studentsNumber;
    @NotNull(message = "ProffessorNumber ni kiriting")
    private int proffessorNumber;
    @NotNull(message = "DoktorantNumber ni kiriting")
    private int doktorantNumber;
    @NotNull(message = "independentResearchersNumber ni kiriting")
    private int independentResearchersNumber;
    @NotNull(message = "AuditoriumNumber ni kiriting")
    private int auditoriumNumber;
    @NotNull(message = "JointTrainingNumber ni kiriting")
    private int jointTrainingNumber;
    @NotNull(message = "FieldsofStudyNUmber ni kiriting")
    private int fieldsofStudyNumber;
    @NotNull(message = "FacultyNumber ni kiriting")
    private int facultyNumber;
}
