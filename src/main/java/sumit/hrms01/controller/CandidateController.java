package sumit.hrms01.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.User;
import sumit.hrms01.model.Job_description;
import sumit.hrms01.service.IAppliedService;
import sumit.hrms01.service.IJobDescriptionService;
import sumit.hrms01.service.IStatusService;
import sumit.hrms01.service.IUserService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {


	
	@Autowired
	IUserService applicantService;
	
	@Autowired
	IStatusService statusService;
	
	@Autowired
	IAppliedService appliedService;
	
	@Autowired
	IJobDescriptionService jobDescriptionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> getAllCandidates(){
		return this.applicantService.list();
	}
	
	@RequestMapping( value = "{id}", 
					 method = RequestMethod.GET
					 )
	public User getApplicant(@PathVariable("id") Long id ) {
		return this.applicantService.findById(id);
	}
	
	@RequestMapping( value = "/{id}/status", 
					 method = RequestMethod.PUT
					 )
	public void changeStatus(@PathVariable("id") Long id, @RequestBody String status) {
		User applicant = this.applicantService.findById(id);
		Long statusId = this.statusService.getStatusId(status);
		applicant.setStatusId(statusId);
	}
	
	@RequestMapping( value = "{id}/applied")
	public Collection<Job_description> getAppliedJobs(@PathVariable("id") Long id){
		List<Long> jobIds = this.appliedService.getAppliedJobIds(id);
		return this.jobDescriptionService.getAllJobsWithIds(jobIds);
		
	}
	
}
