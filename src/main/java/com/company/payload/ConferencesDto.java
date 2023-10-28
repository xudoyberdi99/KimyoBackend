package com.company.payload;

import lombok.Data;

@Data
public class ConferencesDto {
    private String sana;
    private String phone;
    private String email;
    private String address;

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionEN;
    private String descriptionKR;
}
