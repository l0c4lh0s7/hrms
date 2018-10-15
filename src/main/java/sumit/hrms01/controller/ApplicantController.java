package sumit.hrms01.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Applicant;
import sumit.hrms01.model.Roles;
import sumit.hrms01.service.IApplicantService;
import sumit.hrms01.service.IRolesService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

	@Autowired
	IApplicantService applicantService;
	
	@Autowired
	IRolesService rolesService;
	
	@RequestMapping( value="/list", 
					method= RequestMethod.GET
					)
	public Collection<Applicant> list(){
		return this.applicantService.list();
	}
	
	@RequestMapping( value = "/add", 
					 method = RequestMethod.POST
					 )
	public void insertApplicant(@RequestBody Applicant applicant) {
		System.out.println(applicant.toString());
		this.applicantService.insert(applicant);
		Roles role = new Roles();
		role.setApplicantId(applicant.getId());
		role.setRole("USER");
 		this.rolesService.insert(role);
	}
	
	@RequestMapping( value = "/update",
					 method = RequestMethod.PUT)
	public void updateApplicant(@RequestBody Applicant applicant) {
		this.applicantService.update(applicant);
	}
	
	@RequestMapping( value="/{id}", 
					  method = RequestMethod.GET
					  )
	public Applicant findById(@PathVariable ("id") Long id) {
		return (Applicant) this.applicantService.findById(id);
	}
	
	@RequestMapping( value="/remove/{id}", 
					 method = RequestMethod.DELETE
					 )
	public void delete(@PathVariable ("id") Long id) {
		Applicant applicant = new Applicant();
		applicant.setId(id);
		this.applicantService.delete(applicant);
	}
}
