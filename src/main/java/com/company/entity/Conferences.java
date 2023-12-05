package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "conferences")
public class Conferences extends BaceEntity {
    @Column(nullable = false)
    private String sana;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;

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

    @ManyToOne
    private Category category;

}
