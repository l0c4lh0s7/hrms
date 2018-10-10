package sumit.hrms01.service;

import java.util.Collection;

import sumit.hrms01.model.Applicant;

public interface IApplicantService {

	// Basic CRUD operations 
	
	Collection<Applicant> list();

	void insert(Applicant applicant);

	void update(Applicant applicant);

	void delete(Applicant applicant);

	Applicant findById(Long id);
	
	// Custom method
	public Collection<Applicant> getAppliedCandidate(Collection<Long> candidateIds);
	
	public Collection<Applicant> getAllWithStatusId(Long statusId);


}