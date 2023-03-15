package com.datvutech.dvbankws.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.datvutech.dvbankws.data.entity.Authority;
import com.datvutech.dvbankws.data.entity.Customer;
import com.datvutech.dvbankws.data.repository.AuthorityRepository;
import com.datvutech.dvbankws.data.repository.CustomerRepository;

@Component
public class UsernamePasswordAuthentication implements AuthenticationProvider {
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private AuthorityRepository authorityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        Customer customer = customerRepo.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("No user registered with this email!"));
        String pwd = customer.getPwd();
        if (passwordEncoder.matches(password, pwd)) {
            List<GrantedAuthority> authorities = getGrantedAuthorities(customer.getCustomerId());
            return new UsernamePasswordAuthenticationToken(email, pwd, authorities);
        }
        throw new BadCredentialsException("Invalid password!");
    }

    private List<GrantedAuthority> getGrantedAuthorities(long customerId) {
        Iterable<Authority> dbAuthorities = authorityRepo.findByCustomer(customerId);
        List<GrantedAuthority> authorities = new ArrayList<>();
        dbAuthorities.forEach(dbA -> {
            GrantedAuthority ga = new SimpleGrantedAuthority(dbA.getName());
            authorities.add(ga);
        });
        return authorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }

}
