package sumit.hrms01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	  public String fallback() {
	    return "forward:/";
	  }
}

