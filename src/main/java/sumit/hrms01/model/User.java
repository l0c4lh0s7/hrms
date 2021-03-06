package sumit.hrms01.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("dob")
	private Date dob;

	@JsonProperty("qualification")
	private String Qualification;

	@JsonProperty("experience")
	private String experience;

	@JsonProperty("applied_to_id")
	@Column(name = "applied_to_id")
	private Long appliedToId;

	@JsonProperty("status_id")
	@Column(name = "status_id")
	private Long statusId;

	@Column(name = "is_admin")
	@JsonProperty("isAdmin")
	private boolean isAdmin;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
	@JsonManagedReference
	private Credential credential;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", Qualification="
				+ Qualification + ", experience=" + experience + ", appliedToId=" + appliedToId + ", statusId="
				+ statusId + ", isAdmin=" + isAdmin + ", credential=" + credential + "]";
	}


	

}
