package sumit.hrms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Applied_to;
import sumit.hrms01.repository.AppliedRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AppliedService implements IAppliedService {

	@Autowired
	AppliedRepository appliedRepository;
	 
	@Override
	public Collection<Applied_to> list(){
		return (Collection<Applied_to>) this.appliedRepository.findAll();
	}
	
	@Override
	public void insert(Applied_to applied) {
		this.appliedRepository.save(applied);
	}
	
	@Override
	public void update(Applied_to applied) {
		Optional<Applied_to> staleApplied = this.appliedRepository.findById(applied.getId());
		if( staleApplied.isPresent() )
			this.appliedRepository.save(applied);
	}
	
	@Override
	public void delete(Applied_to applied) {
		Optional<Applied_to> staleApplied = this.appliedRepository.findById(applied.getId());
		if( staleApplied.isPresent())
			this.appliedRepository.delete(staleApplied.get());
	}
	
	@Override
	public Applied_to findById(Long id) {
		return this.appliedRepository.findById(id).get();
	}

	@Override
	public List<Long> getAppliedCandidateIds(Long id) {
		List<Long> candidateIds = new ArrayList<Long>();
		for(Applied_to applied: this.appliedRepository.findByJobId(id)) {
			candidateIds.add(applied.getApplicantId());
		}
		return candidateIds;
	}

	@Override
	public List<Long> getAppliedJobIds(Long id) {
		List<Long> jobIds = new ArrayList<Long>();
		for(Applied_to applied: this.appliedRepository.findByApplicantId(id)) {
			jobIds.add(applied.getJobId());
		}
		return jobIds;
	}
}
