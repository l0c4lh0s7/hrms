package sumit.hrms01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JobNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public JobNotFoundException(String message) {
		super(message);
	}
}
