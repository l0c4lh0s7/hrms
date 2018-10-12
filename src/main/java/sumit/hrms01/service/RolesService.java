package sumit.hrms01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Roles;
import sumit.hrms01.repository.RolesRepository;

@Service
public class RolesService implements IRolesService {

	@Autowired
	RolesRepository rolesRepository;
	
	@Override
	public String[] getRoleWithApplicantId(Long applicantId) {
		Roles[] roles =  this.rolesRepository.findByApplicantId(applicantId);
		List<String> roleNames = new ArrayList<String>(); 
		for( Roles role: roles) {
			roleNames.add(role.getRole());
		}
		return roleNames.toArray(new String[0]);
	}

	@Override
	public void insert(Roles role) {
		this.rolesRepository.save(role);
	}
}
