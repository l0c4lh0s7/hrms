package sumit.hrms01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.User;
import sumit.hrms01.service.IUserService;
import sumit.hrms01.util.JWTTokenManager;

@RestController
@RequestMapping("/")
public class LoginController {

	
	@Autowired
	IUserService userService;
	
//	@RequestMapping( method=RequestMethod.GET)
//	public String getLogin() {
//		return "login";
//	}
	
	
	@PostMapping(value="login")
	public ResponseEntity<String> login(@RequestBody User user) {
		
		HttpHeaders headers = new HttpHeaders();
		
		String returnValue = null;
		
		User dbUser = userService.findByEmail(user.getEmail());
		if( dbUser == null )
			returnValue  =  "not registered with us ";
		else {
			String savedPass = dbUser.getCredential().getPassword();
			String pass = user.getCredential().getPassword();
			if( savedPass.equals(pass)) {
				returnValue =  "success login";
				String token = JWTTokenManager.createToken(dbUser.getEmail(), dbUser.isAdmin(), dbUser.getName());
				headers.add("Authorization", token);
			}
			else
				returnValue =  "failed login";
		}
		return new ResponseEntity<>(returnValue,headers,  HttpStatus.OK);
	}
}
