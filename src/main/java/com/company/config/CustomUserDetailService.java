package com.company.config;


import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Keldi: loadUserByUsername.");
        Optional<ProfileEntity> usersOptional = this.profileRepository.findByUsername(s);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        ProfileEntity profile = usersOptional.get();
        System.out.println(profile);

        return new CustomUserDetails(profile);
    }
}
