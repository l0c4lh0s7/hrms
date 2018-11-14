package sumit.hrms01.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public Collection<User> getAllByStatusId(Long statusId);
	
	public User findByEmail(String email);
}
