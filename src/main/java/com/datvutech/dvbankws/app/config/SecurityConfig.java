package com.datvutech.dvbankws.app.config;

import static com.datvutech.dvbankws.app.constant.AppConstants.CUSTOMER_ENDPOINTS;
import static com.datvutech.dvbankws.app.constant.AppConstants.PUBLIC_ENDPOINTS;
import static com.datvutech.dvbankws.app.constant.AppConstants.USER_ROLE;
import static com.datvutech.dvbankws.app.constant.AppConstants.ADMIN_ROLE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import com.datvutech.dvbankws.filter.AuthorityLoggingFilter;
import com.datvutech.dvbankws.filter.CsrfCookieFilter;
import com.datvutech.dvbankws.filter.JwtTokenGeneratorFilter;
import com.datvutech.dvbankws.filter.JwtTokenValidatorFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenRequestAttributeHandler.setCsrfRequestAttributeName("_csrf");
        http
                /*
                 * .securityContext().requireExplicitSave(false)
                 * .and()
                 * .sessionManagement(
                 * (session) -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                 */
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf((csrf) -> csrf.ignoringRequestMatchers(PUBLIC_ENDPOINTS)
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .cors().configurationSource(new CorsConfig())
                .and()
                .authorizeHttpRequests()
                .requestMatchers(CUSTOMER_ENDPOINTS).hasAnyRole(USER_ROLE, ADMIN_ROLE)
                .requestMatchers("/user").authenticated()
                .requestMatchers(PUBLIC_ENDPOINTS).permitAll()
                /*
                 * .requestMatchers("/myAccount").hasAuthority("VIEW_ACCOUNT")
                 * .requestMatchers("/myBalance").hasAnyAuthority("VIEW_ACCOUNT",
                 * "VIEW_BALANCE")
                 * .requestMatchers("/myLoans").hasAuthority("VIEW_LOANS")
                 * .requestMatchers("/myCards").hasAuthority("/VIEW_CARDS")
                 */
                .and()
                .addFilterAfter(new AuthorityLoggingFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .httpBasic()
                .and()
                .formLogin();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
