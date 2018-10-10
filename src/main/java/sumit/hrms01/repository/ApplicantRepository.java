package sumit.hrms01.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Long>{

	public Collection<Applicant> getAllByStatusId(Long statusId);
}
