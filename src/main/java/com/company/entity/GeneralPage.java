package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "generalPage")
public class GeneralPage extends BaceEntity {

    private String titleUZ;
    private String titleRU;
    private String titleKR;
    private String titleEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String contentUZ;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String contentRU;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String contentEN;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String contentKR;

    @ManyToOne(optional = false)
    private Category category;
}
