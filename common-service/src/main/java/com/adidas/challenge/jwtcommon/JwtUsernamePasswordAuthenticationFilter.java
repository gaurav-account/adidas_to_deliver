package com.adidas.challenge.jwtcommon;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Username name and Password Filter.
 * @author Gaurav Kumar
 *
 */
public class JwtUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtAuthenticationConfig jwtAuthenticationConfig;
    private final ObjectMapper mapper;

    /**
     * Arg-Constructor
     * @param jwtAuthenticationConfig
     * @param authManager
     */
    public JwtUsernamePasswordAuthenticationFilter(JwtAuthenticationConfig jwtAuthenticationConfig, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(jwtAuthenticationConfig.getUrl(), "POST"));
        setAuthenticationManager(authManager);
        this.jwtAuthenticationConfig = jwtAuthenticationConfig;
        this.mapper = new ObjectMapper();
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse rsp)
            throws AuthenticationException, IOException {
    	//Creating user object from request json & returing Authentication object.
        User u = mapper.readValue(req.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                u.getUsername(), u.getPassword(), Collections.emptyList()
        ));
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain, org.springframework.security.core.Authentication)
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse rsp, FilterChain chain,
                                            Authentication auth) {
    	//Granting permission for specified time once authentication is successful.
        Instant now = Instant.now();
        String token = Jwts.builder()
                .setSubject(auth.getName())
                .claim("authorities", auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(jwtAuthenticationConfig.getExpiration())))
                .signWith(SignatureAlgorithm.HS256, jwtAuthenticationConfig.getSecret().getBytes())
                .compact();
        rsp.addHeader(jwtAuthenticationConfig.getHeader(), jwtAuthenticationConfig.getPrefix() + " " + token);
    }
}