package com.example.kma_schedule.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenGenerator {

    private static final Key TOKEN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final long JWT_TOKEN_VALIDITY = 3 * 60 * 60;

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getClaimsFromToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        System.out.println("IS TOKEN EXPIRED??? " + isTokenExpired(token));
        return username != null && !isTokenExpired(token);
    }

    public String generateToken(final UserDetails authenticatedUser) {
        final long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(authenticatedUser.getUsername())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + JWT_TOKEN_VALIDITY * 1000))
                .signWith(TOKEN_KEY)
                .compact();
    }

    public String getUsernameFromToken(final String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(TOKEN_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }

}