package ru.itis.security.tokenfactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itis.models.User;
import ru.itis.security.token.JwtToken;
import ru.itis.security.token.TokenType;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Component
public class TokenFactory {

    @Value("${jwt.secret.value}")
    private String secretKey;

    private static final long ACCESS_TOKEN_EXPIRATION_TIME = 30;//30 min
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 10;//10 days

    public JwtToken createAccessToken(User user){

        Claims claims = Jwts.claims()
                .setSubject(String.valueOf(user.getId()))
                .setExpiration(getExpirationDate(TokenType.ACCESS_TOKEN));

        claims.put("login", user.getLogin());
        claims.put("role", String.valueOf(user.getRole()));

        String accessTokenValue = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return JwtToken.builder()
                .claims(claims)
                .value(accessTokenValue)
                .build();
    }

    public JwtToken createRefreshToken(User user){

        Claims claims = Jwts.claims()
                .setId(UUID.randomUUID().toString())
                .setSubject(String.valueOf(user.getId()))
                .setExpiration(getExpirationDate(TokenType.REFRESH_TOKEN));

        claims.put("login", user.getLogin());
        claims.put("role", String.valueOf(user.getRole()));

        String refreshTokenValue = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return JwtToken.builder()
                .claims(claims)
                .value(refreshTokenValue)
                .build();
    }


    private Date getExpirationDate(TokenType tokenType){

        Date currentDate = new Date();

        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        LocalDateTime result;

        switch (tokenType){
            case ACCESS_TOKEN:
                result = localDateTime.plusMinutes(ACCESS_TOKEN_EXPIRATION_TIME);
                break;
            case REFRESH_TOKEN:
                result = localDateTime.plusDays(REFRESH_TOKEN_EXPIRATION_TIME);
                break;
            default:
                throw new IllegalArgumentException("Invalid Token Type!");
        }

        return Date.from(result.atZone(ZoneId.systemDefault()).toInstant());
    }



}
