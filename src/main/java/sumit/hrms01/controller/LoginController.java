package sumit.hrms01.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.User;

@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping( method = RequestMethod.POST)
	public void login(@RequestBody User user) {
		
	}
}
