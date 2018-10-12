package sumit.hrms01.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicantNotFoundException extends RuntimeException{

	public ApplicantNotFoundException(String message) {
		super(message);
	}
}
