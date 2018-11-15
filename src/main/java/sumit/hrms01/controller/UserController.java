package sumit.hrms01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Credential;
import sumit.hrms01.model.User;
import sumit.hrms01.service.ICredentialService;
import sumit.hrms01.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	ICredentialService credentialService;

	@RequestMapping( value="/list", 
					method= RequestMethod.GET
					)
	public List<User> list(){
		return this.userService.list();
	}

//	//Just for checking if credential entity is working properly
//	@RequestMapping(value="/cred")
//	public Credential getcred() {
//		return this.credentialService.getWithId(1L);
//	}
	
	
	@CrossOrigin
	@RequestMapping( value = "/register", 
					 method = RequestMethod.POST
					 )
	public void insertUser(@RequestBody User user) {
		Credential cred = user.getCredential();
		String pass = user.getCredential().getPassword();
		this.userService.insert(user);
		cred.setUser(user);
		this.credentialService.insert(cred);
		
	}
	
	@RequestMapping( value = "/update",
					 method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		Credential cred = user.getCredential();
		this.credentialService.update(cred);
		this.userService.update(user);
	}
	
	@RequestMapping( value="/{id}", 
					  method = RequestMethod.GET
					  )
	public User findById(@PathVariable ("id") Long id) {
		return (User) this.userService.findById(id);
	}
	
	@RequestMapping( value="/remove/{id}", 
					 method = RequestMethod.DELETE
					 )
	public void delete(@PathVariable ("id") Long id) {
		User user = new User();
		user.setId(id);
		this.userService.delete(user);
	}
}
