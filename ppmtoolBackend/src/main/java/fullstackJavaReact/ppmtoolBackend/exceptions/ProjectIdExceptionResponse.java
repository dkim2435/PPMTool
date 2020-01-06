package fullstackJavaReact.ppmtoolBackend.exceptions;

public class ProjectIdExceptionResponse {
	
	private String projectIdentifier;
	
	
	public ProjectIdExceptionResponse(String projectIdentifier) {
		//passing object that has projectIdentifier attribute type string that passes on the JSON message
		this.projectIdentifier = projectIdentifier;
	}


	public String getProjectIdentifier() {
		return projectIdentifier;
	}


	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
	

}
