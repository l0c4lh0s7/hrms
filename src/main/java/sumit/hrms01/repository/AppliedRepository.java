package sumit.hrms01.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.Applied_to;

public interface AppliedRepository extends CrudRepository<Applied_to, Long>{

	public Collection<Applied_to> findByJobId(Long id);
	
	public Collection<Applied_to> findByApplicantId(Long id);
}
