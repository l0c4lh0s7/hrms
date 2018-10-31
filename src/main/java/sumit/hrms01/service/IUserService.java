package sumit.hrms01.service;

import java.util.Collection;
import java.util.List;

import sumit.hrms01.model.User;

public interface IUserService {

	List<User> list();

	void insert(User user);

	void update(User applicant);

	void delete(User user);

	User findById(Long id);

	Collection<User> getAppliedCandidate(Collection<Long> candidateIds);

	Collection<User> getAllWithStatusId(Long statusId);

	Collection<String> getAllUserName();

}