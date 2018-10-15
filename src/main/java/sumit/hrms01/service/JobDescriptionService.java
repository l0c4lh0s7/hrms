package sumit.hrms01.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sumit.hrms01.exceptions.JobNotFoundException;
import sumit.hrms01.model.Job_description;
import sumit.hrms01.repository.JobDescriptionRepository;

@Service
public class JobDescriptionService implements IJobDescriptionService {

	
	@Autowired
	JobDescriptionRepository jdRepository;
	
	@Override
	@Cacheable(value="jobs")
	public Collection<Job_description> list(){
		return (Collection<Job_description>) this.jdRepository.findAll();
	}
	
	@Override
	@CachePut(value="jobs", key="#id")
	public void insert(Job_description jd) {
		System.out.println(jd.toString());
		this.jdRepository.save(jd);
	}
	
	@Override
	public void update(Job_description jd) {
		if( this.jdRepository.existsById(jd.getId()))
			this.jdRepository.save(jd);
	}
	
	@Override
	@CacheEvict(value="jobs", key="#jd.id")
	public void delete(Job_description jd) {
		if ( this.jdRepository.existsById(jd.getId()))
			this.jdRepository.delete(this.jdRepository.findById(jd.getId()).get());
	}
	
	@Override
	@Cacheable(value="jobs", key="#id")
	public Job_description findById(Long id) {
		if(jdRepository.existsById(id))
		return this.jdRepository.findById(id).get();
		else
			throw new JobNotFoundException("JOB id: " + id + " is not associated with any job");
	}

	@Override
	public Collection<Job_description> getWithStatus(String status) {
		boolean isActive = false;
		if( status.equals("active"))
			isActive = true;
		if( status.equals("inactive"))
			isActive = false;
		return this.jdRepository.findByIsactive(isActive);
	}
	
	@Override
	public Collection<Job_description> getAllJobsWithIds(List<Long> jobIds){
		return (Collection<Job_description>) this.jdRepository.findAllById(jobIds);
	}
	
}
