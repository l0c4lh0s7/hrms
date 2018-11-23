package sumit.hrms01.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.exceptions.ApplicantNotFoundException;
import sumit.hrms01.model.User;
import sumit.hrms01.repository.CredentialRepository;
import sumit.hrms01.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CredentialRepository credentialRepository;
	
	@Override
	public List<User> list(){
		return (List<User>) this.userRepository.findAll();
	}
	
	@Override
	public void insert(User user) {
		this.userRepository.save(user);
//		this.credentialRepository.save(credential);
		
	}
	
	@Override
	public void update(User applicant) {
		Optional<User> staleApplicant = this.userRepository.findById(applicant.getId());
		if( staleApplicant.isPresent() )
			this.userRepository.save(applicant);
	}
	
	@Override
	public void delete(User user) {
		Optional<User> existingUser = this.userRepository.findById(user.getId());
		if( existingUser.isPresent())
			this.userRepository.delete(existingUser.get());
	}
	
	@Override
	public User findById(Long id) {
		Optional<User> user =  this.userRepository.findById(id);
		if(!user.isPresent())
			throw new ApplicantNotFoundException("id : " + id + " is not associated with any user");
		else
			return user.get();
	}
	
	@Override
	public Collection<User> getAppliedCandidate(Collection<Long> candidateIds){
		return (Collection<User>) this.userRepository.findAllById(candidateIds);
	}
	
	@Override
	public Collection<User> getAllWithStatusId(Long statusId){
		return this.userRepository.getAllByStatusId(statusId);
	}

	@Override
	public Collection<String> getAllUserName() {
		Collection<String> userNames =new ArrayList<String>(); 
				for(User applicant: this.list()) {
					userNames.add(applicant.getName());
				}
		return userNames;
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
		
	}

	
}
