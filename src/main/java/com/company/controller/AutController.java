package com.company.controller;

import com.company.config.JwtTokenProvider;
import com.company.dto.AuthorizationDTO;
import com.company.entity.User;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(value = "*",maxAge = 3600)
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutController {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> getLogin(@RequestBody AuthorizationDTO loginPayload){

        User user=userRepository.findByUserName(loginPayload.getUserName());

        if (user==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginPayload.getUserName(),loginPayload.getPassword()));

        String token=jwtTokenProvider.createToken(user.getUserName(),user.getRoleList());
        if(token==null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nimadir xato");
        Map<String,Object> result=new HashMap<>();
        result.put("status",true);
        result.put("userName",user.getUserName());
        result.put("token",token);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }


}
