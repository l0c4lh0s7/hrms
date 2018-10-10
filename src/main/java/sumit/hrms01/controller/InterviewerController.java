package sumit.hrms01.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import sumit.hrms01.model.Interviewer;
import sumit.hrms01.service.InterviewerService;

@RestController
@RequestMapping("/interviewer")
public class InterviewerController {

	@Autowired
	InterviewerService interviewerService;

	@RequestMapping( value="/list", 
			method= RequestMethod.GET
			)
	public Collection<Interviewer> list(){
		return this.interviewerService.list();
	}

	@RequestMapping( value = "/add", 
			method = RequestMethod.POST
			)
	public void insertInterviewer(@RequestBody Interviewer interviewer) {
		this.interviewerService.insert(interviewer);
	}

	@RequestMapping( value = "/update",
			method = RequestMethod.PUT)
	public void updateInterviewer(@RequestBody Interviewer interviewer) {
		this.interviewerService.update(interviewer);
	}

	@RequestMapping( value="/{id}", 
			method = RequestMethod.GET
			)
	public Interviewer findById(@PathVariable ("id") Long id) {
		return (Interviewer) this.interviewerService.findById(id);
	}

	@RequestMapping( value="/remove/{id}", 
			method = RequestMethod.DELETE
			)
	public void delete(@PathVariable ("id") Long id) {
		Interviewer interviewer = new Interviewer();
		interviewer.setId(id);
		this.interviewerService.delete(interviewer);
	}

}
