package sumit.hrms01.service;

import java.util.Collection;

import sumit.hrms01.model.Admin;

public interface IAdminService {

	void insert(Admin admin);

	void update(Admin admin);

	void delete(Admin admin);

	Admin findById(Long id);

	Collection<Admin> list();

}