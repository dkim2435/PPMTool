package fullstackJavaReact.ppmtoolBackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fullstackJavaReact.ppmtoolBackend.domain.Project;
import fullstackJavaReact.ppmtoolBackend.exceptions.ProjectIdException;
import fullstackJavaReact.ppmtoolBackend.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	// autowire/inject to the repository package to use the built in function inside the repository package
	private ProjectRepository projectRepository;
	
	//CRUD METHODS:
	public Project saveOrUpdateProject(Project project) {
		// tries to save the created project and if it already exists, it'll catch into the ProjectIdException file for an duplicate
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			 return projectRepository.save(project);
		}catch(Exception e){
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase()+"' already exist");
		}
		
	}
}
