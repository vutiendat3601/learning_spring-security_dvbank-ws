package com.datvutech.dvbankws.filter;

import static com.datvutech.dvbankws.app.constant.AppConstants.PUBLIC_ENDPOINTS;
import static com.datvutech.dvbankws.app.constant.SecurityConstants.JWT_AUTHORITIES_CLAIM;
import static com.datvutech.dvbankws.app.constant.SecurityConstants.JWT_EMAIL_CLAIM;
import static com.datvutech.dvbankws.app.constant.SecurityConstants.JWT_HEADER;
import static com.datvutech.dvbankws.app.constant.SecurityConstants.JWT_KEY;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = request.getHeader(JWT_HEADER);
        if (jwt != null) {
            try {
                final SecretKey secretKey = Keys.hmacShaKeyFor(JWT_KEY
                        .getBytes(StandardCharsets.UTF_8));
                final Claims claims = Jwts.parserBuilder()
                        .setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody();
                String email = String.valueOf(claims.get(JWT_EMAIL_CLAIM));
                String authoritiesClaim = claims.get(JWT_AUTHORITIES_CLAIM, String.class);

                List<GrantedAuthority> authorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList(authoritiesClaim);
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        email, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                throw new BadCredentialsException("Invalid token received!");
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        final String servletPath = request.getServletPath();
        return Arrays.stream(PUBLIC_ENDPOINTS)
                .anyMatch((pe) -> pe.equalsIgnoreCase(servletPath))
                || servletPath.equalsIgnoreCase("/user");
    }

}
