package com.company.component;

import com.company.entity.ProfileEntity;
import com.company.entity.enums.ROLES;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String initialModeType;

    @Override
    public void run(String... args) throws Exception {
        if(initialModeType.equals("create")){
            profileRepository.save(new ProfileEntity(
                    "SuperAdmin","admin123",true, ROLES.ADMIN.name()
            ));
            profileRepository.save(new ProfileEntity(
                    "Admin","admin",true, ROLES.USER.name()
            ));
        }
    }
}
