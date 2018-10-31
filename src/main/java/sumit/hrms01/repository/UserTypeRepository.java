package sumit.hrms01.repository;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Long>{

	public UserType findByUserId(Long userId);
}
