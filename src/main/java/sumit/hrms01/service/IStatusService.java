package sumit.hrms01.service;

import java.util.Collection;

import sumit.hrms01.model.Status;

public interface IStatusService {

	Collection<Status> list();

	void insert(Status status);

	void update(Status status);

	void delete(Status status);

	Status findById(Long id);
	
	// Custom methods
	
	public Long getStatusId(String status);

}