package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Role extends BaceEntity implements GrantedAuthority {
    String name;
    @Override
    public String getAuthority() {
        return name;
    }
}
