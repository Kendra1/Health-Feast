package sbnz.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import sbnz.model.User;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static java.util.Collections.singletonList;

import static sbnz.security.SecurityConstants.TOKEN_HEADER;
import static sbnz.security.SecurityConstants.TOKEN_PREFIX;
import static sbnz.security.SecurityConstants.TOKEN_SECRET;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(TOKEN_HEADER);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            throw new PreAuthenticatedCredentialsNotFoundException(
                    "Token is not in request or is not valid.");
        }

        setAuthentication(header.replace(TOKEN_PREFIX, ""));

        chain.doFilter(request, response);
    }

    @SuppressWarnings("unchecked")
	private void setAuthentication(String token) {

        Claims claims = null;

        try {

            claims = Jwts.parser().setSigningKey(TOKEN_SECRET.getBytes()).parseClaimsJws(token).getBody();

            Map<Object, Object> userMap = (Map<Object, Object>) claims.get("user");

            User user = new ObjectMapper().convertValue(userMap, User.class);

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            user, null, singletonList(new SimpleGrantedAuthority(user.getRole().toString())));

            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (ExpiredJwtException ex) {
            throw new ExpiredJwtException(null, claims, "Token has expired.");
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }
    }
}
