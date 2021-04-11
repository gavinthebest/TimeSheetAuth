package com.AuthServer.config.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

	public static String generateToken(String signingKey, Map<String, String> claims) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		JwtBuilder builder = Jwts.builder();

		for (String claim : claims.keySet())
			builder.claim(claim, claims.get(claim));

		builder.setIssuedAt(now)
//                .setExpiration()
				.signWith(SignatureAlgorithm.HS256, signingKey);

		return builder.compact();
	}
}
