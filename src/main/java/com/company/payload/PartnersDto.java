package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
public class PartnersDto {
    @NotBlank(message = "please provide a icon")
    private String icon;
    private String description;
}
