package ru.itis.security.provider;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.security.authentication.JwtAuthentication;
import ru.itis.security.details.UserDetailsImpl;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Value("${jwt.secret.value}")
    private String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        JwtAuthentication jwtAuthentication = (JwtAuthentication) authentication;

        Claims body;

        try {
            body = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(authentication.getName())
                    .getBody();
        }catch (IllegalArgumentException| MalformedJwtException | SignatureException | ExpiredJwtException e){
            e.printStackTrace();
            throw new AuthenticationServiceException("Invalid token");
        }

        UserDetails userDetails = new UserDetailsImpl(
                Long.parseLong(String.valueOf(body.get("sub"))),
                String.valueOf(body.get("login")),
                String.valueOf(body.get("role"))
        );

        jwtAuthentication.setUserDetails(userDetails);
        jwtAuthentication.setAuthenticated(true);

        return jwtAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.equals(authentication);
    }
}
