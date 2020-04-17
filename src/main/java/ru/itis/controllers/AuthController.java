package ru.itis.controllers;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.auth.LoginDto;
import ru.itis.dto.auth.RegistrationDto;

@RestController
public class AuthController {

    @PostMapping("/login")
    public AuthenticationDto login(@RequestBody LoginDto login){
        return null;
    }

    @PostMapping("/registrate")
    public void registrate(@RequestBody RegistrationDto registration){

    }
}
