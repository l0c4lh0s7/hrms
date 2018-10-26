package sumit.hrms01.config;


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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sumit.hrms01.model.Admin;
import sumit.hrms01.model.Applicant;
import sumit.hrms01.service.IAdminService;
import sumit.hrms01.service.IApplicantService;
import sumit.hrms01.service.IRolesService;

@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer{

//	@Value("${client[0].username}")
//	String user;
//	@Value("${client[0].password}")
//	String pass;
//	@Value("${client[0].roles}")
//	String []roles;
	
	@Autowired
	IRolesService rolesService;
	
	@Autowired
	IApplicantService applicantService;
	
	@Autowired
	IAdminService adminService;
	
	@Bean
	public UserDetailsService userDetailsService() throws Exception{
		UserBuilder users = User.withDefaultPasswordEncoder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		List<Admin> admins =  (List<Admin>) adminService.list();
		List<Applicant> applicants = (List<Applicant>) applicantService.list();
		for( Applicant applicant: applicants) {
			manager.createUser(users.username(applicant.getName()).password("DEFAULT")
					.roles(rolesService.getRoleWithApplicantId(applicant.getId())).build());
		}
		for( Admin admin: admins) {
			manager.createUser(users.username(admin.getName()).password("admin")
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
				.authorizeRequests().antMatchers("/job/add","admin/**","/admin", "/job","/jobdesc/add").hasRole("ADMIN")

				// Remove authentication from the links that are accessible to all
				.and().authorizeRequests().antMatchers("/applicant/list").permitAll()
				
				// Then make all remaining requests authenticated
				.and().authorizeRequests().anyRequest().authenticated()

				// If user failed to authenticate provide them with a form to authenticate themselves
				.and().formLogin()
				.and().csrf().disable()
				.httpBasic();
		}
	}
}