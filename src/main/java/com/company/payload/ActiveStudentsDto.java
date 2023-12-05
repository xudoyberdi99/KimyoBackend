package com.company.payload;

import com.company.entity.enums.StudentStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotBlank(message = "iltimos hashidni kiriting")
    private String DescriptionUZ;
    @NotBlank(message = "iltimos hashidni kiriting")
    private String DescriptionRU;
    @NotBlank(message = "iltimos hashidni kiriting")
    private String DescriptionEN;
    @NotBlank(message = "iltimos hashidni kiriting")
    private String DescriptionKR;
    @NotBlank(message = "Statusini kiriting")
    private String status;
    @NotNull
    private Long categoryid;

}
