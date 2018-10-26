package sumit.hrms01.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Status;
import sumit.hrms01.repository.StatusRepository;

@Service
public class StatusService implements IStatusService {

	@Autowired
	StatusRepository statusRepository;
	
	@Override
	public Collection<Status> list(){
		return (Collection<Status>) this.statusRepository.findAll();
	}
	
	@Override
	public void insert(Status status) {
		this.statusRepository.save(status);
	}
	
	@Override
	public void update(Status status) {
		if( this.statusRepository.existsById(status.getId()))
			this.statusRepository.save(status);
	}
	
	@Override
	public void delete(Status status) {
		if( this.statusRepository.existsById(status.getId()))
			this.statusRepository.delete(this.statusRepository.findById(status.getId()).get());
	}
	
	@Override
	public Status findById(Long id) {
		return this.statusRepository.findById(id).get();
	}
	
	@Override
	public Long getStatusId(String status) {
		return this.statusRepository.findByStatus(status).getId();
	}
}
