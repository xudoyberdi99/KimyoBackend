package com.company.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class GeneralInformationDto {

   @NotNull(message = "StudentsNumber ni kiriting")
    private int StudentsNumber;
    @NotNull(message = "ProffessorNumber ni kiriting")
    private int ProffessorNumber;
    @NotNull(message = "DoktorantNumber ni kiriting")
    private int DoktorantNumber;
    @NotNull(message = "independentResearchersNumber ni kiriting")
    private int independentResearchersNumber;
    @NotNull(message = "AuditoriumNumber ni kiriting")
    private int AuditoriumNumber;
    @NotNull(message = "JointTrainingNumber ni kiriting")
    private int JointTrainingNumber;
    @NotNull(message = "FieldsofStudyNUmber ni kiriting")
    private int FieldsofStudyNumber;
    @NotNull(message = "FacultyNumber ni kiriting")
    private int FacultyNumber;
}
