package sumit.hrms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Permission;
import sumit.hrms01.repository.PermissionRepository;

@Service
public class PermissionService implements IPermissionService {

	@Autowired
	PermissionRepository permissionRepository;
	
	@Override
	public String[] getPermissionWithUserId(Long userId) {
		Permission permission = this.permissionRepository.findByUserId(userId);
		String []permissions = permission.getPermissions().split(",");
		return permissions;
	}

	@Override
	public void insert(Permission permission) {
		this.permissionRepository.save(permission);
	}
	
	public void update(Permission permission) {
		if( this.permissionRepository.findById(permission.getId()) != null )
			this.permissionRepository.save(permission);
	}
	
	public void delete(Permission permission) {
		if( this.permissionRepository.existsById(permission.getId()))
			this.permissionRepository.delete(permission);
		
	}
}
