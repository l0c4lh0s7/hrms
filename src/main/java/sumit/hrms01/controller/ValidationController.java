package sumit.hrms01.controller;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.service.IUserService;

/**
 * @author sumit.bhakt
 *
 */
@RestController
@RequestMapping("/validate")
public class ValidationController {

	@Autowired
	IUserService userService;
	
	/**
	 * parameter : email 
	 * returns true if email is the list 
	 * else false 
	 */
	@RequestMapping(value="email", method=RequestMethod.GET)
	public boolean validateEmail(@RequestParam("email") String email) {
			if( this.userService.findByEmail(email) != null) {
				System.out.println(this.userService.findByEmail(email));
				return true;
			}
		return false;
	}
	
}
