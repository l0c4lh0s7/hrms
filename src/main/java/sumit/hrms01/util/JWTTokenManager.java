package sumit.hrms01.util;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenManager {
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String SECRET = "SecretKeyToGenJWTs";

	public static String createToken(String subject, boolean isAdmin) {
		String token = Jwts.builder()
				.setSubject(subject)
				.claim("admin" , isAdmin)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
		
		return token;
	}
}
