package sumit.hrms01.service;

import sumit.hrms01.model.Credential;

public interface ICredentialService {

	void insert(Credential credential);
	
	void delete(Credential credential);

	void update(Credential credential);

	Credential getWithId(long id);


}