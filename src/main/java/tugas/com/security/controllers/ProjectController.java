package tugas.com.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tugas.com.security.models.Department;
import tugas.com.security.models.Project;
import tugas.com.security.models.ResponseMessage;
import tugas.com.security.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
//@PreAuthorize("hasRole('ADMIN')")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
//    @PreAuthorize("hasAuthority('READ_DATA')")
    public ResponseEntity<List<Project>> getAll(){
        return new ResponseEntity(projectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('READ_DATA')")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id){
        return new ResponseEntity(projectService.getById(id), HttpStatus.OK);
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('CREATE_DATA')")
    public ResponseEntity<Project> create(@RequestBody Project project){
        return new ResponseEntity(new ResponseMessage<Project>
                (projectService.create(project), "project created"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('UPDATE_DATA')")
    public ResponseEntity<Project> update(@PathVariable("id") Long id, @RequestBody Project project){
        return new ResponseEntity(projectService.update(id,project), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAuthority('DELETE_DATA')")
    public ResponseEntity<Project> delete(@PathVariable("id") Long id){
        return new ResponseEntity(projectService.delete(id), HttpStatus.OK);
    }
}
