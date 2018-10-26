package sumit.hrms01.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Status;
import sumit.hrms01.service.IStatusService;

@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	IStatusService statusService;
	
	@RequestMapping( value="/list", 
			method= RequestMethod.GET
			)
	public Collection<Status> list(){
		return this.statusService.list();
	}

	@RequestMapping( value = "/add", 
			method = RequestMethod.POST
			)
	public void insertStatus(@RequestBody Status status) {
		this.statusService.insert(status);
	}

	@RequestMapping( value = "/update",
			method = RequestMethod.PUT)
	public void updateStatus(@RequestBody Status status) {
		this.statusService.update(status);
	}

	@RequestMapping( value="/{id}", 
			method = RequestMethod.GET
			)
	public Status findById(@PathVariable ("id") Long id) {
		return (Status) this.statusService.findById(id);
	}

	@RequestMapping( value="/remove/{id}", 
			method = RequestMethod.DELETE
			)
	public void delete(@PathVariable ("id") Long id) {
		Status status = new Status();
		status.setId(id);
		this.statusService.delete(status);
	}
}
