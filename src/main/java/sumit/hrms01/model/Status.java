package sumit.hrms01.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Status implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
        @JsonProperty("id")
        private Long id;
	
        @JsonProperty("status")
	private String status;
	
	public Status() { 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}
	
	
	
}
