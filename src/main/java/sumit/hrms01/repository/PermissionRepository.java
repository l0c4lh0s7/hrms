package sumit.hrms01.repository;

import org.springframework.data.repository.CrudRepository;

import sumit.hrms01.model.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long>{
	
	public Permission findByUserId(Long userId);
}
