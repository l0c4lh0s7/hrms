package sumit.hrms01.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.UserType;
import sumit.hrms01.repository.UserTypeRepository;

@Service
public class UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;
	
	public Collection<UserType> list(){
		return (Collection<UserType>)this.userTypeRepository.findAll();
	}
	
	
	public UserType findByUserId(Long userId) {
		return this.userTypeRepository.findByUserId(userId);
	}
	
	public void insert(UserType userType) {
		this.userTypeRepository.save(userType);
	}
	
	public void delete(UserType userType) {
		this.userTypeRepository.delete(userType);
	}
	
	public void update(UserType userType) {
		if( this.userTypeRepository.existsById(userType.getId()) )
			this.userTypeRepository.save(userType);
	}
	
	
}
