package sumit.hrms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Permission;
import sumit.hrms01.repository.PermissionRepository;

@Service
public class PermissionService implements IPermissionService {

	@Autowired
	PermissionRepository rolesRepository;
	
	@Override
	public String[] getPermissionWithApplicantId(Long applicantId) {
		Permission permission = this.rolesRepository.findByApplicantId(applicantId);
		String []permissions = permission.getPermissions().split(",");
		return permissions;
	}

	@Override
	public void insert(Permission permission) {
		this.rolesRepository.save(permission);
	}
	
}
