package tenzor.soft.test.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tenzor.soft.test.dto.CreateProjectDto;
import tenzor.soft.test.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import tenzor.soft.test.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        return ResponseEntity.ok(projectService.createProject(createProjectDto));
    }

}
