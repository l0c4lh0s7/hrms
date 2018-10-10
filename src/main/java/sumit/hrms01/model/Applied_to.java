package sumit.hrms01.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Entity
public class Applied_to implements Serializable{

	private static final long serialVersionUID = 1L;
	

        @Id
        @JsonProperty("id")
	private Long id;
	
        @JsonProperty("job_id")
	private int job_id;
        
        @JsonProperty("applicant_id")
	private int applicant_id;
        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}
	@Override
	public String toString() {
		return "Applied_to [id=" + id + ", job_id=" + job_id + ", applicant_id=" + applicant_id + "]";
	}
	
	public Applied_to() {
		
	}
}