package tenzor.soft.test.service;

import tenzor.soft.test.dto.CreateProjectDto;
import tenzor.soft.test.dto.ProjectDto;
import tenzor.soft.test.dto.UpdateProjectDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Page<ProjectDto> getListOfProjects(Pageable pageable);

    ProjectDto createProject(CreateProjectDto createProjectResponse);

    ProjectDto updateProject(UpdateProjectDto updateProjectDto);

    void deleteProject(Long id);

}
