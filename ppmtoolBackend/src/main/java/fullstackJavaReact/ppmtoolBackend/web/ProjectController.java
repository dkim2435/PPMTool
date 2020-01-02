package fullstackJavaReact.ppmtoolBackend.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fullstackJavaReact.ppmtoolBackend.domain.Project;
import fullstackJavaReact.ppmtoolBackend.services.ProjectService;


//this is the API that we are going to use to operate the CRUD method.

@RestController
@RequestMapping("/api/project")

public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	
	//Create a new route that we can POST our new project.
	@PostMapping("")
	// ResponseEntity lets us have control to our JSON objects.
	// Adding @Valid will display 400 status if the object created is invalid
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
		}
		
		// saves the project object to the database
		// make sure when testing in postman, id is auto generated.
		Project project1 = projectService.saveOrUpdateProject(project);
		
		// if the POST works, it will show 201 CREATED.
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}


}
