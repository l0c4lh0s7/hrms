package sumit.hrms01.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Job_description;
import sumit.hrms01.service.JobDescriptionService;

@RestController
@RequestMapping("/jobdesc")
public class JobDescriptionController {

	@Autowired
	JobDescriptionService jdService;
	
	@RequestMapping( value="/list", 
			method= RequestMethod.GET
			)
	public Collection<Job_description> list(){
		return this.jdService.list();
	}


	@RequestMapping( value = "/add", 
			method = RequestMethod.POST
			)
	public void insertJob_description(@RequestBody Job_description jd) {
		this.jdService.insert(jd);
	}

	@RequestMapping( value = "/update",
			method = RequestMethod.PUT)
	public void updateJob_description(@RequestBody Job_description jd) {
		this.jdService.update(jd);
	}

	@RequestMapping( value="/{id}", 
			method = RequestMethod.GET
			)
	public Job_description findById(@PathVariable ("id") Long id) {
		return (Job_description) this.jdService.findById(id);
	}

	@RequestMapping( value="/remove/{id}", 
			method = RequestMethod.DELETE
			)
	public void delete(@PathVariable ("id") Long id) {
		Job_description jd = new Job_description();
		jd.setId(id);
		this.jdService.delete(jd);
	}
}
