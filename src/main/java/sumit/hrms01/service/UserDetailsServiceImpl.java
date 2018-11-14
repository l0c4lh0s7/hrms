package sumit.hrms01.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sumit.hrms01.model.User;
import sumit.hrms01.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User applicationUser = userRepository.findByEmail(username);
		if( applicationUser == null ) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(applicationUser.getEmail(),
												applicationUser.getCredential().getPassword(),
												new ArrayList<>());
	}
	
	
}
