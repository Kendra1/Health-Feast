package sbnz.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import sbnz.model.User;

import java.util.Date;

import static sbnz.security.SecurityConstants.TOKEN_EXP;
import static sbnz.security.SecurityConstants.TOKEN_PREFIX;
import static sbnz.security.SecurityConstants.TOKEN_SECRET;

public class JwtUtil {

    public String createJwt(User user) {
        return TOKEN_PREFIX + Jwts.builder()
                .setSubject(user.getEmail())
                .claim("user", user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
                .signWith(Keys.hmacShaKeyFor(TOKEN_SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailFromToken(String token) {
        String email;
        try {
            Claims claims = this.getClaimsFromToken(token);
            email = claims.getSubject();
        } catch (Exception e) {
            email = null;
        }
        return email;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
