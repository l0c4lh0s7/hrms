package sumit.hrms01.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer{

	@Value("${client.username}")
	String user;
	@Value("${client.password}")
	String pass;
	@Value("${client.roles}")
	String []roles;

	
	@Bean
	public UserDetailsService userDetailsService() throws Exception{
		UserBuilder users = User.withDefaultPasswordEncoder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(users.username(user).password(pass).roles(roles).build());
		manager.createUser(users.username("newUser").password("password1").roles("ADMIN").build());
		return manager;
	}
	
	@Configuration
	@Order(1)
	public static class Authorizations extends WebSecurityConfigurerAdapter{
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests().antMatchers("/candidate/**").hasRole("USER")
				.and().authorizeRequests().antMatchers("/job/**").permitAll()
				.and().httpBasic();
		}
	}

}
