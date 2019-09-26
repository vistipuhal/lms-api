package com.fairwaysoftware.lms.security;

import com.fairwaysoftware.lms.service.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class TokenHelper {

    public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer";

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(User user) {
        return Jwts.builder().setSubject(user.getUserId().toString()).signWith(key).compact();
    }

    public Integer parseToken(String token) {
        return Integer.parseInt(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject());
    }

}
