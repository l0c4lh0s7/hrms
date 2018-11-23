package sumit.hrms01.controller;

import java.util.ArrayList;
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
@RequestMapping("/job")
public class JobController {

	@Autowired
	IJobDescriptionService jobDescriptionService;
	
	@Autowired
	IStatusService statusService;
	
	@Autowired
	IAppliedService appliedService;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping( method = RequestMethod.GET)
	public Collection<Job_description> getAllJobs(){
		return this.jobDescriptionService.list();
	}
	
	@RequestMapping(value="/{job}",
			method = RequestMethod.GET
			)
	public Job_description getJobWithId(@PathVariable("job") Long job){
		return this.jobDescriptionService.findById(job);
	}
	
	@RequestMapping(value = "/status/{status}",
					method= RequestMethod.GET 
					)
	public Collection<Job_description> getJobsWithStatus(@PathVariable ("status") String status){
		return this.jobDescriptionService.getWithStatus(status);
	}
	
	// candidates applied at job id
	@RequestMapping(value = "/{job}/applied", 
					method = RequestMethod.GET
					)
	public Collection<User> getListOfCandidatesAppliedToJob(@PathVariable ("job") Long job){
		List<Long> candidateIds = this.appliedService.getAppliedCandidateIds(job);
		return this.userService.getAppliedCandidate(candidateIds);
	}
	
	// candidate whose status is statusName
	@RequestMapping( value = "/applied/candidate/{status}", 
					 method = RequestMethod.GET
					 )
	public Collection<User> getCandidatesWithStatus(@PathVariable ("status") String status){
		Long statusId = this.statusService.getStatusId(status);
		return this.userService.getAllWithStatusId(statusId);
	}
	
	// Candidate applied at job id and are having statusName
	@RequestMapping( value = "/{job}/applied/candidate/{status}", 
					 method = RequestMethod.GET
				)
	public Collection<User> getCandidatesWithJobidAndStatus(@PathVariable("job") Long job, 
																@PathVariable("status")String status){
		Collection<User> applicantWithGivenJobId= this.getListOfCandidatesAppliedToJob(job);
		Collection<User> applicantWithGivenStatus = this.getCandidatesWithStatus(status);
		Collection<User> result = new ArrayList<User>();
		for( User applicant: applicantWithGivenJobId) {
			if(applicantWithGivenStatus.contains(applicant))
				result.add(applicant);
		}
		return result;
	}
		
	@RequestMapping( value = "/update",
			method = RequestMethod.PUT)
	public void updateJob_description(@RequestBody Job_description jd) {
		System.out.println("Got request to update : " +  jd);
		this.jobDescriptionService.update(jd);
	}
	
	@RequestMapping( value = "/create", 
			method = RequestMethod.POST
			)
	public void insertJob_description(@RequestBody Job_description jd) {
		this.jobDescriptionService.insert(jd);
	}
	
	@RequestMapping( value="/remove/{id}", 
			method = RequestMethod.DELETE
			)
	public void delete(@PathVariable ("id") Long id) {
		Job_description jd = new Job_description();
		jd.setId(id);
		this.jobDescriptionService.delete(jd);
	}
}
