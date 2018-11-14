package sumit.hrms01.config;

public class SecurityConstants {

	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGNUP_URL = "/user/register";
    public static final String LOGIN_URL = "/login";
}
