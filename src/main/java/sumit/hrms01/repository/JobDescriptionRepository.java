package sumit.hrms01.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;


import sumit.hrms01.model.Job_description;

public interface JobDescriptionRepository extends CrudRepository<Job_description, Long>{

	public Collection<Job_description> findByIsactive(Boolean status);
}
