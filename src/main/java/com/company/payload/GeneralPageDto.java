package com.company.payload;

import com.company.entity.Category;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Data
public class GeneralPageDto {

    private String titleUZ;

    private String titleRU;

    private String titleKR;

    private String titleEN;


    private String contentUZ;

    private String contentRU;

    private String contentEN;

    private String contentKR;

    private Long categoryId;
}
