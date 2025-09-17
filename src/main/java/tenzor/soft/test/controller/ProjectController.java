package tenzor.soft.test.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tenzor.soft.test.dto.CreateProjectDto;
import tenzor.soft.test.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import tenzor.soft.test.dto.UpdateProjectDto;
import tenzor.soft.test.service.ProjectService;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<Page<ProjectDto>> listProjects(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(projectService.getListOfProjects(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDto> creeateProject(@RequestBody CreateProjectDto createProjectDto) {
        return projectService.createProject(createProjectDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody UpdateProjectDto updProjectDto) {
        return projectService.updateProject(updProjectDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        return projectService.deleteProject(id);
    }

}
