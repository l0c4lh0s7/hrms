/*package sumit.hrms01.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// This is complete earlier code 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import sumit.hrms01.model.User;
import sumit.hrms01.service.IUserService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig implements WebMvcConfigurer{

//	@Value("${client[0].username}")
//	String user;
//	@Value("${client[0].password}")
//	String pass;
//	@Value("${client[0].roles}")
//	String []roles;
	
	@Autowired
	IUserService userService;
	
	

	
	@Bean
	public UserDetailsService userDetailsService() throws Exception{
		UserBuilder users = User.withDefaultPasswordEncoder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		List<sumit.hrms01.model.User> applicants =  userService.list();
		
		manager.createUser(users.username("dummyUser").password("DEFAULT")
				.roles("USER").build());
		
		for( sumit.hrms01.model.User applicant: applicants) {
			if( !applicant.isAdmin() )
			manager.createUser(users.username(applicant.getName()).password("DEFAULT")
					.roles("USER").build());
			else
				manager.createUser(users.username(applicant.getName()).password("admin")
						.roles("ADMIN").build());
			
		}
		
		return manager;
	}
	
	@Configuration
	@Order(1)
	public static class Authorizations extends WebSecurityConfigurerAdapter{
		
		@Autowired
		IUserService userService;
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			 return new BCryptPasswordEncoder();
		}
		
		// Added http security to the endpoints
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers("/job/list").hasAnyRole("USER")
				.anyRequest().authenticated()
				.and().httpBasic();
		}
		
		// Any request that needs to be allowed is placed here 
		@Override
		public void configure(WebSecurity web) throws Exception{
			web.ignoring().antMatchers("/*", "/user/list", "/login");
		}
		
		 
	}
}

*/