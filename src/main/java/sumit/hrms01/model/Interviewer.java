package sumit.hrms01.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@Entity
public class Interviewer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
        @JsonProperty("id")
	private Long id;
	
        @JsonProperty("name")
	private String name;
        
        @JsonProperty("skills")
	private String skills;
        
        @JsonProperty("Position")
	private String position;
        
        @JsonProperty("feedback")
	private String feedback;
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
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Interviewer [id=" + id + ", name=" + name + ", skills=" + skills + ", position=" + position
				+ ", feedback=" + feedback + "]";
	}
	
	public Interviewer() {
	}
}
