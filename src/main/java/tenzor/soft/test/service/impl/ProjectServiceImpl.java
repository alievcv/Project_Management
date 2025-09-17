package tenzor.soft.test.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tenzor.soft.test.dto.CreateProjectDto;
import tenzor.soft.test.dto.ProjectDto;
import tenzor.soft.test.dto.UpdateProjectDto;
import tenzor.soft.test.entity.Category;
import tenzor.soft.test.entity.Project;
import tenzor.soft.test.mapper.ProjectMapper;
import tenzor.soft.test.repository.CategoryRepository;
import tenzor.soft.test.repository.ProjectsRepository;
import tenzor.soft.test.service.ProjectService;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectsRepository projectsRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Page<ProjectDto> getListOfProjects(Pageable pageable) {
        return projectsRepository.findAll(pageable).map(ProjectMapper::toDto);
    }

    @Override
    public ProjectDto createProject(CreateProjectDto createProjectResponse) {
        Integer days = (int) ChronoUnit.DAYS.between(LocalDate.now(), createProjectResponse.endDate());
        System.out.println("Days between: " + days);

        Category category = categoryRepository.getByName(createProjectResponse.projectCategory().name());
        Project project = Project.builder()
                .name(createProjectResponse.projectName())
                .category(category)
                .revenue(createProjectResponse.salesRevenue())
                .fromDate(createProjectResponse.fromDate())
                .endDate(createProjectResponse.endDate())
                .PMName(createProjectResponse.PMName())
                .remainingDays(days)
                .build();

        return ProjectMapper.toDto(projectsRepository.save(project));

    }

    @Override
    public ProjectDto updateProject(UpdateProjectDto updateProjectDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProject'");
    }

    @Override
    public void deleteProject(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProject'");
    }

}
