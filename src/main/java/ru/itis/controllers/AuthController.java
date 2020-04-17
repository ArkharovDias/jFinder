package ru.itis.controllers;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.auth.AuthenticationDto;
import ru.itis.dto.auth.LoginDto;
import ru.itis.dto.auth.RegistrationDto;
import ru.itis.services.LoginService;

@RestController
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public AuthenticationDto login(@RequestBody LoginDto loginDto){
        return loginService.doLogin(loginDto);
    }

    @PostMapping("/registrate")
    public void registrate(@RequestBody RegistrationDto registration){

    }
}
