package com.adidas.challenge.jwtcommon;

import org.springframework.beans.factory.annotation.Value;


/**
 * POJO class for Jwt Authentication Config
 * @author Gaurav Kumar
 *
 */
public class JwtAuthenticationConfig {

    @Value("${adidas.security.jwt.url:/login}")
    private String url;

    @Value("${adidas.security.jwt.header:Authorization}")
    private String header;

    @Value("${adidas.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${adidas.security.jwt.expiration:#{24*60*60}}")
    private int expiration; 

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Value("${adidas.security.jwt.secret}")
    private String secret;
}
