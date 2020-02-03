package fullstackJavaReact.ppmtoolBackend.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
// makes this entity to create table with attributes we define here.
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Validations
	@NotBlank(message = "Project name is required") // This attribute cannot be blank
	private String projectName;
	
	@NotBlank(message = "Project Identifier is required") // This attribute cannot be blank
	@Size(min=4, max=5, message="Please use 4 to 5 characters") //Restricts the limit of characters
	@Column(updatable = false, unique = true) // allows you to set parameters to itself
	private String projectIdentifier;
	
	@NotBlank(message="Project description is required") // This attribute cannot be blank
	private String description;
	
	@JsonFormat(pattern ="yyyy-mm-dd") //shows the date is this pattern rather than default pattern from JSON
	private Date start_date;
	@JsonFormat(pattern ="yyyy-mm-dd") //shows the date is this pattern rather than default pattern from JSON
	private Date end_date;
	
	@JsonFormat(pattern ="yyyy-mm-dd") //shows the date is this pattern rather than default pattern from JSON
	@Column(updatable = false)
	private Date created_At;
	@JsonFormat(pattern ="yyyy-mm-dd") //shows the date is this pattern rather than default pattern from JSON
	private Date updated_At;
	
	//Constructor
	public Project() {
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	
	@PrePersist
	protected void onCreate() {
		//every time we create a new object, we are going to store the date
		this.created_At = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		// every time we update an object, we are going to update the date
		this.updated_At = new Date();
	}
	
}
