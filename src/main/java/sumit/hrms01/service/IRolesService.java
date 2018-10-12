package sumit.hrms01.service;

import sumit.hrms01.model.Roles;

public interface IRolesService {

	String[] getRoleWithApplicantId(Long applicantId);
	
	void insert(Roles role);

}