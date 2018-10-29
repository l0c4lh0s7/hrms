package sumit.hrms01.service;

import sumit.hrms01.model.Permission;

public interface IPermissionService {

	String[] getPermissionWithApplicantId(Long applicantId);
	
	void insert(Permission permission);
	
}