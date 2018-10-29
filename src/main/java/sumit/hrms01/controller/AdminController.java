package sumit.hrms01.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Applicant;
import sumit.hrms01.service.IApplicantService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IApplicantService applicantService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Applicant> addAdmin() {
		return this.applicantService.list();
	}
	
}
