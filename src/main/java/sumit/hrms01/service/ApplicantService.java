package sumit.hrms01.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Applicant;
import sumit.hrms01.repository.ApplicantRepository;

@Service
public class ApplicantService implements IApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;
	
	@Override
	public Collection<Applicant> list(){
		Collection<Applicant> applicants = (Collection<Applicant>) this.applicantRepository.findAll();
		return applicants;
	}
	
	@Override
	public void insert(Applicant applicant) {
		this.applicantRepository.save(applicant);
	}
	
	@Override
	public void update(Applicant applicant) {
		Optional<Applicant> staleApplicant = this.applicantRepository.findById(applicant.getId());
		if( staleApplicant.isPresent() )
			this.applicantRepository.save(applicant);
	}
	
	@Override
	public void delete(Applicant applicant) {
		Optional<Applicant> existingApplicant = this.applicantRepository.findById(applicant.getId());
		if( existingApplicant.isPresent())
			this.applicantRepository.delete(existingApplicant.get());
	}
	
	@Override
	public Applicant findById(Long id) {
		return this.applicantRepository.findById(id).get();
	}
}
