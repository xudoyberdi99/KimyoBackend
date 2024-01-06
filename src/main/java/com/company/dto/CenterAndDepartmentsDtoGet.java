package com.company.dto;

import com.company.entity.CenterAndDepartmentsEmployees;
import lombok.Data;

import java.util.List;

@Data
public class CenterAndDepartmentsDtoGet {
    private Long id;
    private String nameUZ;
    private String nameRU;
    private String nameEN;
    private String nameKR;

    private String titleUZ;
    private String titleRU;
    private String titleEN;
    private String titleKR;

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionEN;
    private String descriptionKR;

    List<CenterAndDepartmentsEmployeesGet> employees;
}
