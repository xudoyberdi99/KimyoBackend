package com.company.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AppealsDto {

    @NotNull(message = "iltimos ismingizni kiriting")
    private String fullName;

    @NotNull(message = "iltimos emailingizni kiriting")
    private String email;

    private String text;
}
