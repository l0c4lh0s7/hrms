package sumit.hrms01.config;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import sumit.hrms01.model.User;
import sumit.hrms01.service.IUserService;

@EnableWebSecurity
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
		
		protected void configure(HttpSecurity http) throws Exception {
			http
				// First add authorizations for admin level 
//				.authorizeRequests().antMatchers("/job/add","admin/**","/admin", "/job","/jobdesc/add").hasRole("ADMIN")

			// Remove authentication from the links that are accessible to all
				.authorizeRequests().antMatchers("/**").permitAll()
//			    .authorizeRequests().antMatchers("/user/register","user/list").permitAll()
				
				// Then make all remaining requests authenticated
				.and().authorizeRequests().anyRequest().authenticated()

				// If user failed to authenticate provide them with a form to authenticate themselves
				.and().formLogin()
				.and().csrf().disable()
				.httpBasic();
		}
	}
}