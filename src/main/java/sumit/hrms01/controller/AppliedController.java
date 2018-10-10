package sumit.hrms01.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sumit.hrms01.model.Applied_to;
import sumit.hrms01.service.IAppliedService;


@RestController
@RequestMapping("/applied")
public class AppliedController {

	@Autowired
	IAppliedService appliedService;
	
	@RequestMapping( value="/list", 
			method= RequestMethod.GET
			)
	public Collection<Applied_to> list(){
		return this.appliedService.list();
	}

	@RequestMapping( value = "/add", 
			method = RequestMethod.POST
			)
	public void insertApplied_to(@RequestBody Applied_to applied) {
		this.appliedService.insert(applied);
	}

	@RequestMapping( value = "/update",
			method = RequestMethod.PUT)
	public void updateApplied_to(@RequestBody Applied_to applied) {
		this.appliedService.update(applied);
	}

	@RequestMapping( value="/{id}", 
			method = RequestMethod.GET
			)
	public Applied_to findById(@PathVariable ("id") Long id) {
		return (Applied_to) this.appliedService.findById(id);
	}

	@RequestMapping( value="/remove/{id}", 
			method = RequestMethod.DELETE
			)
	public void delete(@PathVariable ("id") Long id) {
		Applied_to applied = new Applied_to();
		applied.setId(id);
		this.appliedService.delete(applied);
	}
	
}
