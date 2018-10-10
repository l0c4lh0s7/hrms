package sumit.hrms01.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Job_description implements Serializable{

	
	
	private static final long serialVersionUID = 1L;

	@Id
        @JsonProperty("id")
        private Long id;
	
        @JsonProperty("description")
	private String description;
        
        @JsonProperty("isActive")
    private boolean isactive;

		@JsonProperty("vacancies")
	private int vacancies;
        
        @JsonProperty("filled")
	private int filled;
        
        @JsonProperty("position")
	private String position;
        
        @JsonProperty("ctc")
	private String CTC;
	
        @JsonProperty("bond")
	private boolean bond;
        
        @JsonProperty("bond_years")
	private int bond_years;
        
        @JsonProperty("applied_to_id")
	private Long applied_to_id;
        
        @JsonProperty("interviewer_id")
	private Long interviewer_id;
        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    public boolean isactive() {
		return isactive;
	}
	public void setActive(boolean isactive) {
		this.isactive = isactive;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public int getFilled() {
		return filled;
	}
	public void setFilled(int filled) {
		this.filled = filled;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCTC() {
		return CTC;
	}
	public void setCTC(String cTC) {
		CTC = cTC;
	}
	public boolean Bond() {
		return bond;
	}
	public void setBond(boolean bond) {
		this.bond = bond;
	}
	public int getBond_years() {
		return bond_years;
	}
	public void setBond_years(int bond_years) {
		this.bond_years = bond_years;
	}
	public Long getApplied_to_id() {
		return applied_to_id;
	}
	public void setApplied_to_id(Long applied_to_id) {
		this.applied_to_id = applied_to_id;
	}
	public Long getInterviewer_id() {
		return interviewer_id;
	}
	public void setInterviewer_id(Long interviewer_id) {
		this.interviewer_id = interviewer_id;
	}
	@Override
	public String toString() {
		return "Job_description [id=" + id + ", description=" + description + ", vacancies=" + vacancies + ", filled="
				+ filled + ", position=" + position + ", CTC=" + CTC + ", isBond=" + bond + ", bond_years="
				+ bond_years + ", applied_to_id=" + applied_to_id + ", interviewer_id=" + interviewer_id + "]";
	}
	
	public Job_description() {
	}
}