package com.company.payload;

import com.company.entity.enums.StudentStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class ActiveStudentsDto {
    @NotBlank(message = "iltimos fullNameini kiriting")
    private String fullName;
    @NotBlank(message = "iltimos hashidni kiriting")
    private String hashId;

    private String degree;

    private String directionUZ;
    private String directionRU;
    private String directionEN;
    private String directionKR;

    private String DescriptionUZ;
    private String DescriptionRU;
    private String DescriptionEN;
    private String DescriptionKR;

    private StudentStatus status;

}
