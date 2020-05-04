package ru.itis.services;

import ru.itis.dto.auth.RegistrationDto;

public interface RegistrationService {
    void register(RegistrationDto registrationDto);
}
