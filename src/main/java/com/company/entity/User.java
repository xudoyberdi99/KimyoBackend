package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Base64;
import java.util.List;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User extends BaceEntity {

    @Column(unique = true,nullable = false)
    String userName;
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roleList;  // ROLE_ADMIN ROLE_USER
}
