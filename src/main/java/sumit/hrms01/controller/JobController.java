package sumit.hrms01.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Applicant;
import sumit.hrms01.model.Job_description;
import sumit.hrms01.service.IApplicantService;
import sumit.hrms01.service.IAppliedService;
import sumit.hrms01.service.IJobDescriptionService;
import sumit.hrms01.service.IStatusService;

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
	IApplicantService applicantService;
	
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
	public Collection<Applicant> getListOfCandidatesAppliedToJob(@PathVariable ("job") Long job){
		List<Long> candidateIds = this.appliedService.getAppliedCandidateIds(job);
		return this.applicantService.getAppliedCandidate(candidateIds);
	}
	
	// candidate whose status is statusName
	@RequestMapping( value = "/applied/candidate/{status}", 
					 method = RequestMethod.GET
					 )
	public Collection<Applicant> getCandidatesWithStatus(@PathVariable ("status") String status){
		Long statusId = this.statusService.getStatusId(status);
		return this.applicantService.getAllWithStatusId(statusId);
	}
	
	// Candidate applied at job id and are having statusName
	@RequestMapping( value = "/{job}/applied/candidate/{status}", 
					 method = RequestMethod.GET
				)
	public Collection<Applicant> getCandidatesWithJobidAndStatus(@PathVariable("job") Long job, 
																@PathVariable("status")String status){
		Collection<Applicant> applicantWithGivenJobId= this.getListOfCandidatesAppliedToJob(job);
		Collection<Applicant> applicantWithGivenStatus = this.getCandidatesWithStatus(status);
		Collection<Applicant> result = new ArrayList<Applicant>();
		for( Applicant applicant: applicantWithGivenJobId) {
			if(applicantWithGivenStatus.contains(applicant))
				result.add(applicant);
		}
		return result;
	}
		
	
}
