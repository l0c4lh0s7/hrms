package sumit.hrms01.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Admin;
import sumit.hrms01.repository.AdminRepository;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public void insert(Admin admin) {
		this.adminRepository.save(admin);
	}
	
	@Override
	public void update(Admin admin) {
		if( this.adminRepository.findById(admin.getId()) != null )
			this.adminRepository.save(admin);
	}
	
	@Override
	public void delete(Admin admin) {
		if( this.findById(admin.getId() ) != null )
			this.adminRepository.delete(admin);
		
	}
	
	@Override
	public Admin findById(Long id) {
		return this.adminRepository.findById(id).get(); 
	}
	
	@Override
	public Collection<Admin> list(){
		return (Collection<Admin>)this.adminRepository.findAll();
	}
}
