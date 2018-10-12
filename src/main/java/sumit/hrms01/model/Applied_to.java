package sumit.hrms01.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Entity
public class Applied_to implements Serializable{

	private static final long serialVersionUID = 1L;
	

        @Id
    	@GeneratedValue(strategy=GenerationType.AUTO)
        @JsonProperty("id")
	private Long id;
	
        @JsonProperty("job_id")
        @Column(name = "job_id")
	private Long jobId;
        
        @JsonProperty("applicant_id")
	private Long applicantId;

		@Override
		public String toString() {
			return "Applied_to [id=" + id + ", job_id=" + jobId + ", applicant_id=" + applicantId + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	

		public Long getJobId() {
			return jobId;
		}

		public void setJobId(Long jobId) {
			this.jobId = jobId;
		}

		public Long getApplicantId() {
			return applicantId;
		}

		public void setApplicantId(Long applicantId) {
			this.applicantId = applicantId;
		}

		
	
}