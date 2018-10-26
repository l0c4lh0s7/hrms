package sumit.hrms01.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	@Column(name="idadmin")
	private Long id;
	
	@JsonProperty("name")
	private String name;

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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + "]";
	}
	
	
}
