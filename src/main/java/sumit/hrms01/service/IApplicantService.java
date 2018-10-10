package sumit.hrms01.service;

import java.util.Collection;

import sumit.hrms01.model.Applicant;

public interface IApplicantService {

	Collection<Applicant> list();

	void insert(Applicant applicant);

	void update(Applicant applicant);

	void delete(Applicant applicant);

	Applicant findById(Long id);

}