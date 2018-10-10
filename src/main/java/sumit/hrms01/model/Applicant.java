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
        @Column( name = "applied_to_id")
	private Long appliedToId;
        
        @JsonProperty("status_id")
        @Column(name = "status_id")
	private Long statusId;

		@Override
		public String toString() {
			return "Applicant [id=" + id + ", name=" + name + ", dob=" + dob + ", Qualification=" + Qualification
					+ ", experience=" + experience + ", appliedToId=" + appliedToId + ", statusId=" + statusId + "]";
		}

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

		public Long getAppliedToId() {
			return appliedToId;
		}

		public void setAppliedToId(Long appliedToId) {
			this.appliedToId = appliedToId;
		}

		public Long getStatusId() {
			return statusId;
		}

		public void setStatusId(Long statusId) {
			this.statusId = statusId;
		}
        
        
        

}
