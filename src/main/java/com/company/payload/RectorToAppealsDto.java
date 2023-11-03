package com.company.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RectorToAppealsDto {
    @NotNull(message = "iltimos ismingizni kiriting")
    private String firstName;

    @NotNull(message = "iltimos ismingizni kiriting")
    private String lastName;

    @NotNull(message = "iltimos emailingizni kiriting")
    private String email;

    @NotNull(message = "iltimos emailingizni kiriting")
    private String phonrNumber;

    private String attachment;

    private String text;
}
