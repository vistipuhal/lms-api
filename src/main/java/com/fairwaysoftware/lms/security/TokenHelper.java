package com.fairwaysoftware.lms.security;

import com.fairwaysoftware.lms.service.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@Component
public class TokenHelper {

    public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer";
    private Key key;

    public TokenHelper(@Value("#{environment.JWT_KEY ?: 'thiskeyhastobeatleastthismanycharactershgahsd'}") String key) {
        if (StringUtils.isEmpty(key) || key.length() < 44) {
            throw new RuntimeException("JWT_KEY needs to be 44 characters long");
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(key);
        this.key = new SecretKeySpec(keyBytes, signatureAlgorithm.getJcaName());
    }

    public String generateToken(User user) {
        return Jwts.builder().setSubject(user.getUserId().toString()).signWith(key).compact();
    }

    public Integer parseToken(String token) {
        return Integer.parseInt(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject());
    }

}
