package com.company.component;

import com.company.entity.Role;
import com.company.entity.User;
import com.company.repository.RoleRepository;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    String init;
    @Override
    public void run(String... args) throws Exception {
        try {
            if (init.equals("create")) {
                Role roleAdmin = new Role();
                roleAdmin.setName("ROLE_ADMIN");
                roleRepository.save(roleAdmin);

                Role roleUser = new Role();
                roleUser.setName("ROLE_USER");
                roleRepository.save(roleUser);

                User admin =new User();
                admin.setUserName("SuperAdmin");
                admin.setPassword(passwordEncoder.encode("123"));
                admin.setRoleList(Collections.singletonList(roleAdmin));
                userRepository.save(admin);

                User user=new User();
                user.setUserName("Admin");
                user.setPassword(passwordEncoder.encode("1234"));
                user.setRoleList(Collections.singletonList(roleUser));

                userRepository.save(user);


            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
