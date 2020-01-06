package fullstackJavaReact.ppmtoolBackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fullstackJavaReact.ppmtoolBackend.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	Project findByProjectIdentifier(String projectId);

	// used to find all the projects
	@Override
	Iterable<Project> findAll();
	

	
}
