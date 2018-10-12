package sumit.hrms01;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sumit.hrms01.repository.ApplicantRepository;
import sumit.hrms01.service.ApplicantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	
	@InjectMocks
	private ApplicantService service;
	
	@Mock
	private ApplicantRepository repository;
		
	@Test
	public void listMethodTest() {
		service.list();
		verify(repository).findAll();
	}
}
