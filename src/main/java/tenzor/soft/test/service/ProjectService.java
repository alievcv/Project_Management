package tenzor.soft.test.service;

import org.springframework.http.ResponseEntity;
import tenzor.soft.test.dto.CreateProjectDto;
import tenzor.soft.test.dto.ProjectDto;
import tenzor.soft.test.dto.UpdateProjectDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Page<ProjectDto> getListOfProjects(Pageable pageable);

    ResponseEntity<ProjectDto> createProject(CreateProjectDto createProjectResponse);

    ResponseEntity<ProjectDto> updateProject(UpdateProjectDto updateProjectDto);

    String deleteProject(Long id);

}
