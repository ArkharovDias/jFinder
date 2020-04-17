package ru.itis.services;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.auth.AuthenticationDto;
import ru.itis.dto.auth.LoginDto;
import ru.itis.dto.item.StudentItemDto;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.security.token.JwtToken;
import ru.itis.security.tokenfactory.TokenFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenFactory tokenFactory;

    @Transactional
    @Override
    public AuthenticationDto doLogin(LoginDto loginDto) {

        AuthenticationDto authenticationDto;

        Optional<User> userCandidate = usersRepository.getUserByLogin(loginDto.getLogin());

        if (userCandidate.isPresent()){

            User user = userCandidate.get();

            if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){

                JwtToken accessToken = tokenFactory.createAccessToken(user);
                JwtToken refreshToken = tokenFactory.createRefreshToken(user);

                authenticationDto = AuthenticationDto.builder()
                        .jwtToken(accessToken.getValue())
                        .refreshToken(refreshToken.getValue())
                        .studentItemDto(StudentItemDto.from(user))
                        .build();

                user.setRefreshToken(refreshToken.getValue());
                usersRepository.save(user);

            }else {
                throw new IllegalArgumentException("Incorrect password!");
            }
        }else {
            throw new IllegalArgumentException("User not Found!");
        }

        return authenticationDto;
    }

}
