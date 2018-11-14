package sumit.hrms01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import sumit.hrms01.model.User;
import sumit.hrms01.service.IUserService;

import static sumit.hrms01.config.SecurityConstants.SIGNUP_URL;
import static sumit.hrms01.config.SecurityConstants.LOGIN_URL;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	IUserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().authorizeRequests()
			.antMatchers(HttpMethod.POST, SIGNUP_URL).permitAll()
			.antMatchers("/*").permitAll()
			.antMatchers("/**").hasRole("ADMIN")
			.antMatchers("/job").hasAnyRole("USER")
			.anyRequest().authenticated()
			.and().httpBasic();
	}
	
	  @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		  	List<User> usersList =  userService.list();
		  	for( User user : usersList ) {
		  		if( user.isAdmin() ) {
		  		auth.inMemoryAuthentication().withUser(user.getEmail())
		  									 .password("{noop}"+ user.getCredential().getPassword())
		  									 .roles("ADMIN");

		  		}
		  		else {
		  			auth.inMemoryAuthentication().withUser(user.getEmail())
						 						 .password("{noop}"+ user.getCredential().getPassword())
						 						 .roles("USER");

		  		}
	        
		  	}
	        
	    }
}
