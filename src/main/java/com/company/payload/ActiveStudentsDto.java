package com.company.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ActiveStudentsDto {
    @NotBlank(message = "iltimos fullNameini kiriting")
    private String fullName;
    @NotBlank(message = "iltimos hashidni kiriting")
    private String hashId;
}
