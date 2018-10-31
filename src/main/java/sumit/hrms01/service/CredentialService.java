package sumit.hrms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Credential;
import sumit.hrms01.repository.CredentialRepository;

@Service
public class CredentialService implements ICredentialService {

	@Autowired
	CredentialRepository credentialRepository;
	
//	@Autowired
//	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public void insert(Credential credential) {
//		credential.setPassword(bcryptPasswordEncoder.encode(credential.getPassword()));
		this.credentialRepository.save(credential);
	}
	
	@Override
	public void delete(Credential credential) {
		this.credentialRepository.delete(credential);
	}
	
	@Override
	public void update(Credential credential) {
		if( this.credentialRepository.findById(credential.getId()) != null )
		this.credentialRepository.save(credential);
	}

	@Override
	public Credential getWithId(long id) {
		return this.credentialRepository.findById(id).get();
	}
}
