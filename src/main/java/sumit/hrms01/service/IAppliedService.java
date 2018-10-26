package sumit.hrms01.service;

import java.util.Collection;
import java.util.List;

import sumit.hrms01.model.Applied_to;

public interface IAppliedService {

	Collection<Applied_to> list();

	void insert(Applied_to applied);

	void update(Applied_to applied);

	void delete(Applied_to applied);

	Applied_to findById(Long id);
	
	// Custom methods 
	
	List<Long> getAppliedCandidateIds(Long id);
	
	List<Long> getAppliedJobIds(Long id);

}