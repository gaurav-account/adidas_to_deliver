package com.adidas.challenge.apigateway;

import com.adidas.challenge.jwtcommon.JwtAuthenticationConfig;
import com.adidas.challenge.jwtcommon.JwtTokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * Security Configuration Implementation class
 * @author Gaurav Kumar
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationConfig config;

    @Bean
    public JwtAuthenticationConfig jwtConfig() {
        return new JwtAuthenticationConfig();
    }

    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
    	//setting parameters for httpSecurity, authorizing user, hystrix and swagger access
		httpSecurity
				.csrf()
				.disable()
				.logout()
				.disable()
				.formLogin()
				.disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.anonymous()
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(
						(req, rsp, e) -> rsp
								.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and()
				.addFilterAfter(new JwtTokenAuthenticationFilter(config),
						UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(config.getUrl())
				.permitAll()
				.antMatchers("/airlines/*")
				.hasRole("ADMIN")
				.antMatchers("/airlines/*")
				.hasRole("USER")
				.antMatchers("/hystrix", "/hystrix/**", "/**/hystrix.stream",
						"/proxy.stream")
				.permitAll()
				.antMatchers("/swagger-resources/**", "/swagger-ui.html",
						"/webjars/**", "/v2/api-docs", "/**/v2/api-docs")
				.permitAll();
	}
}