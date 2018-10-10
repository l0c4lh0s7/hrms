package sumit.hrms01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sumit.hrms01.model.Interviewer;
import sumit.hrms01.repository.InterviewerRepository;

import java.util.*;

@Service
public class InterviewerService implements IInterviewerRepository {

	
	@Autowired
	InterviewerRepository interviewerRepository;
	
	@Override
	public Collection<Interviewer> list(){
		return (Collection<Interviewer> )this.interviewerRepository.findAll();
	}
	
	@Override
	public void insert(Interviewer interviewer) {
		this.interviewerRepository.save(interviewer);
	}
	
	@Override
	public void update(Interviewer interviewer) {
		Interviewer staleInterviewer = this.interviewerRepository.findById(interviewer.getId()).get();
		if( staleInterviewer != null)
			this.interviewerRepository.save(interviewer);
	}
	
	@Override
	public void delete(Interviewer interviewer) {
		Interviewer staleInterviewer = this.interviewerRepository.findById(interviewer.getId()).get();
		this.interviewerRepository.delete(staleInterviewer);
	}
	
	@Override
	public Interviewer findById(Long id) {
		return this.interviewerRepository.findById(id).get();
	}
	
}
