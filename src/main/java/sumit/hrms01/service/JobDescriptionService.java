package sumit.hrms01.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Job_description;
import sumit.hrms01.repository.JobDescriptionRepository;

@Service
public class JobDescriptionService implements IJobDescriptionService {

	
	@Autowired
	JobDescriptionRepository jdRepository;
	
	@Override
	public Collection<Job_description> list(){
		return (Collection<Job_description>) this.jdRepository.findAll();
	}
	
	@Override
	public void insert(Job_description jd) {
		this.jdRepository.save(jd);
	}
	
	@Override
	public void update(Job_description jd) {
		if( this.jdRepository.existsById(jd.getId()))
			this.jdRepository.save(jd);
	}
	
	@Override
	public void delete(Job_description jd) {
		if ( this.jdRepository.existsById(jd.getId()))
			this.jdRepository.delete(this.jdRepository.findById(jd.getId()).get());
	}
	
	@Override
	public Job_description findById(Long id) {
		return this.jdRepository.findById(id).get();
	}
	
}
