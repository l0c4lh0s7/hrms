package sumit.hrms01.repository;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long>{

	public Status findByStatus(String status);
}
