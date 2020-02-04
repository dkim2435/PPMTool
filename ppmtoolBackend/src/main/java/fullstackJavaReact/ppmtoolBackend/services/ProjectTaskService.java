package fullstackJavaReact.ppmtoolBackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fullstackJavaReact.ppmtoolBackend.domain.Backlog;
import fullstackJavaReact.ppmtoolBackend.domain.ProjectTask;
import fullstackJavaReact.ppmtoolBackend.repositories.BacklogRepository;
import fullstackJavaReact.ppmtoolBackend.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		
		// EXCEPTIONS: Project not found
		
		// all Project Tasks to be added to a specific project, project != null, Backlog exists
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		// Set the backlog to the project task
		projectTask.setBacklog(backlog);
		
		// we want our project sequence to be like this: IDPRO-1    IDPRO-2    IDPRO-3 ...100   101
		Integer BacklogSequence = backlog.getPTSequence();
		// Update the Backlog Sequence
		BacklogSequence++;
		
		backlog.setPTSequence(BacklogSequence);
		
		// Add sequence to Project Task
		projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);
		

		// initial status when status is null
		if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
			projectTask.setStatus("TO_DO");
		}
		
		// Initial Priority when priority is null
		if (projectTask.getPriority() == null) {
			projectTask.setPriority(3);
		}
		
		return projectTaskRepository.save(projectTask);
	}
	
	
}
