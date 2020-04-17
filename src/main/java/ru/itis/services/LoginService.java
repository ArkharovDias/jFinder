package ru.itis.services;

import ru.itis.dto.auth.AuthenticationDto;
import ru.itis.dto.auth.LoginDto;

import java.util.Map;

public interface LoginService {
    AuthenticationDto doLogin(LoginDto loginDto);
}
