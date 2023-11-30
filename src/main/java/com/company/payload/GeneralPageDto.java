package com.company.payload;

import com.company.entity.Category;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class GeneralPageDto {

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionKR;
    private String descriptionEN;


    private Long categoryId;
}
