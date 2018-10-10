package sumit.hrms01.service;

import java.util.Collection;

import sumit.hrms01.model.Job_description;

public interface IJobDescriptionService {

	Collection<Job_description> list();	

	void insert(Job_description jd);

	void update(Job_description jd);

	void delete(Job_description jd);

	Job_description findById(Long id);

}