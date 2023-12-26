package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "vacancies")
public class Vacancies extends BaceEntity {
    @Column(nullable = false)
    private String nameUZ;
    @Column(nullable = false)
    private String nameRU;
    @Column(nullable = false)
    private String nameEN;
    @Column(nullable = false)
    private String nameKR;

    private String salary;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionKR;


}
