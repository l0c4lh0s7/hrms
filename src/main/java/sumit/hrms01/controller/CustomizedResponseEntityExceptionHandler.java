package sumit.hrms01.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sumit.hrms01.exceptions.ExceptionDetail;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	// Now this method is mapped to every exception that could happen at runtime
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ExceptionDetail> 
	handleApplicantNotFoundException(RuntimeException ex,
													  WebRequest request){
		ExceptionDetail exceptionDetail = new ExceptionDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}

}
