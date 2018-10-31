package sumit.hrms01.service;

import sumit.hrms01.model.Permission;

public interface IPermissionService {

	String[] getPermissionWithUserId(Long userId);
	
	void insert(Permission permission);
	public void update(Permission permission);
	public void delete(Permission permission);
	
}