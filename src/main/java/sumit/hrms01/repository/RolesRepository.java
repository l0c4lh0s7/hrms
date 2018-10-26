package sumit.hrms01.repository;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Long>{
	
	public Roles[] findByApplicantId(Long applicantId);
}
