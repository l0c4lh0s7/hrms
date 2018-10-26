package sumit.hrms01.service;

import java.util.Collection;

import sumit.hrms01.model.Interviewer;

public interface IInterviewerService {

	Collection<Interviewer> list();

	void insert(Interviewer interviewer);

	void update(Interviewer interviewer);

	void delete(Interviewer interviewer);

	Interviewer findById(Long id);

}