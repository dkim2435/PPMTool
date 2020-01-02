package fullstackJavaReact.ppmtoolBackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fullstackJavaReact.ppmtoolBackend.domain.Project;
import fullstackJavaReact.ppmtoolBackend.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	// autowire/inject to the repository package to use the built in function inside the repository package
	private ProjectRepository projectRepository;
	
	//CRUD METHODS:
	public Project saveOrUpdateProject(Project project) {
		return projectRepository.save(project);
	}
}
