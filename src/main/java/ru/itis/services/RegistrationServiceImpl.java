package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.dto.auth.RegistrationDto;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.security.role.Role;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationDto registrationDto) {

        if(registrationDto.getPassword().equals(registrationDto.getPasswordConfirm())){
            User user = User.builder()
                    .login(registrationDto.getLogin())
                    .password(passwordEncoder.encode(registrationDto.getPassword()))
                    .name(registrationDto.getProfile().getName())
                    .phoneNumber(registrationDto.getProfile().getPhone())
                    .role(Role.STUDENT)
                    .build();

            userRepository.save(user);
        }else {
            throw new IllegalArgumentException("Passwords not equals!");
        }
    }
}
