package fullstackJavaReact.ppmtoolBackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fullstackJavaReact.ppmtoolBackend.domain.Backlog;
import fullstackJavaReact.ppmtoolBackend.domain.Project;
import fullstackJavaReact.ppmtoolBackend.exceptions.ProjectIdException;
import fullstackJavaReact.ppmtoolBackend.repositories.BacklogRepository;
import fullstackJavaReact.ppmtoolBackend.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	// autowire/inject to the repository package to use the built in function inside the repository package
	private ProjectRepository projectRepository;
	
	@Autowired
	private BacklogRepository backlogRepository;
	
//CRUD METHODS:
	
// Create a new project object
	public Project saveOrUpdateProject(Project project) {
		// tries to save the created project and if it already exists, it'll catch into the ProjectIdException file for an duplicate
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			// create new backlog only when new project is created so we don't need separate API call for the backlog
			if(project.getId() == null ) {
				Backlog backlog = new Backlog();
				project.setBacklog(backlog);
				backlog.setProject(project);
				backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			}
			
			if(project.getId() != null) {
				project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
			}
			
			 return projectRepository.save(project);
		}catch(Exception e){
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase()+"' already exist");
		}
		
	}
	
// Find a project by Project Identifier
	public Project findProjectByIdentifier(String projectId) {
		
		//extract project object
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		// projectId.toUpperCase() allows you to type in lowercase id and still read it as a UpperCase and get the project object associated. 
	
		if(project == null) {
			throw new ProjectIdException("Project ID '" + projectId+"' does not exist"); 
		}
		
		return project;
				
	}
	
// Find all the project objects in project List
	// Iterable returns all the JSON object within the List
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	
// Delete a project by project identifier
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Cannot delete Project with ID '" + projectId + "'. This project does not exist");
		}
		
		projectRepository.delete(project);
	}
}
