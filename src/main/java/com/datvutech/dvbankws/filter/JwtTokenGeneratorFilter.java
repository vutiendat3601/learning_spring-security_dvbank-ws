package com.datvutech.dvbankws.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.datvutech.dvbankws.app.constant.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            Date now = new Date();
            String athoritiesClaim = String.join(",",
                    authentication.getAuthorities().stream()
                            .map((a) -> a.getAuthority()).collect(Collectors.toSet()));
            String jwt = Jwts.builder().setIssuer("DVBank").setSubject("JWT Token")
                    .claim(SecurityConstants.JWT_EMAIL_CLAIM, authentication.getName())
                    .claim("authorities", athoritiesClaim)
                    .setIssuedAt(now)
                    .setExpiration(new Date(now.getTime() + 3_000_000))
                    .signWith(secretKey).compact();
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user");
    }
}
