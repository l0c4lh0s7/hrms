package sumit.hrms01.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Applicant implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
        @JsonProperty("id")
	private Long id;
	
        @JsonProperty("name")
	private String name;
        
        @JsonProperty("dob")
	private Date dob;
	
        @JsonProperty("qualification")
        private String Qualification;
        
        @JsonProperty("experience")
	private String experience;
        
        @JsonProperty("applied_to_id")
	private Long applied_to_id;
        
        @JsonProperty("status_id")
	private Long status_id;
        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Long getApplied_to_id() {
		return applied_to_id;
	}
	public void setApplied_to_id(Long applied_to_id) {
		this.applied_to_id = applied_to_id;
	}
	public Long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}
	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", dob=" + dob + ", Qualification=" + Qualification
				+ ", experience=" + experience + ", applied_to_id=" + applied_to_id + ", status_id=" + status_id + "]";
	}
	
	public Applicant() {
	}
}
