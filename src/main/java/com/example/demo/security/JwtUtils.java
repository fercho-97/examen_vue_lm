package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	@Value("${app.jwtSemilla}")
	private String jwtSemilla;


	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	public boolean validateJwtToken(String authToken) {

		try {

			Jwts.parser().setSigningKey(
					this.jwtSemilla)
					.parseClaimsJws(authToken);

			return true;
		} catch (Exception e) {

			LOG.error("Error.....", e);
		}
		return false;

	}

	public String getUserNameFromJwtToken(String token) {

		return Jwts.parser().setSigningKey(
				this.jwtSemilla)
				.parseClaimsJws(token).getBody().getSubject();

	}

}
