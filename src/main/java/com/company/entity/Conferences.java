package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "conferences")
public class Conferences extends BaceEntity {

    private String sana;
    private String phone;
    private String email;
    private String address;

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionEN;
    private String descriptionKR;

}
