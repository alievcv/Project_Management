package tenzor.soft.test.service;

import org.springframework.http.ResponseEntity;
import tenzor.soft.test.dto.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ResponseEntity<List<ProjectDto>> searchByNameContainingIgnoreCase(String name);

    Page<ProjectDto> filter(String name, String type, String status, Pageable pageable);

    ResponseEntity<List<ProjectStatusCountDto>> getGroupedByProjectStatus();

    Page<ProjectDto> getListOfProjects(Pageable pageable);

    ResponseEntity<ProjectDto> createProject(CreateProjectDto createProjectResponse);

    ResponseEntity<ProjectDto> updateProject(UpdateProjectDto updateProjectDto);

    String deleteProject(Long id);

}
