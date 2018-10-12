package sumit.hrms01.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sumit.hrms01.exceptions.ApplicantNotFoundException;
import sumit.hrms01.exceptions.ExceptionDetail;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ApplicantNotFoundException.class)
	public final ResponseEntity<ExceptionDetail> 
	handleApplicantNotFoundException(ApplicantNotFoundException ex,
													  WebRequest request){
		ExceptionDetail exceptionDetail = new ExceptionDetail(new Date(), "ITS ME", request.getDescription(false));
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}

}
