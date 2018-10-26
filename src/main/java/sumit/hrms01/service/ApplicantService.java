package sumit.hrms01.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.exceptions.ApplicantNotFoundException;
import sumit.hrms01.model.Applicant;
import sumit.hrms01.repository.ApplicantRepository;

@Service
public class ApplicantService implements IApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;
	
	@Override
	public Collection<Applicant> list(){
		return (Collection<Applicant>) this.applicantRepository.findAll();
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
		Optional<Applicant> applicant =  this.applicantRepository.findById(id);
		if(!applicant.isPresent())
			throw new ApplicantNotFoundException("id : " + id + " is not associated with any user");
		else
			return applicant.get();
	}
	
	@Override
	public Collection<Applicant> getAppliedCandidate(Collection<Long> candidateIds){
		return (Collection<Applicant>) this.applicantRepository.findAllById(candidateIds);
	}
	
	@Override
	public Collection<Applicant> getAllWithStatusId(Long statusId){
		return this.applicantRepository.getAllByStatusId(statusId);
	}

	@Override
	public Collection<String> getAllUserName() {
		Collection<String> userNames =new ArrayList<String>(); 
				for(Applicant applicant: this.list()) {
					userNames.add(applicant.getName());
				}
		return userNames;
	}
}
