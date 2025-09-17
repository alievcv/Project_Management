package tenzor.soft.test.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import tenzor.soft.test.dto.*;
import tenzor.soft.test.entity.Category;
import tenzor.soft.test.entity.Project;
import tenzor.soft.test.enums.ProjectStatus;
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
    public ResponseEntity<List<ProjectStatusCountDto>> getGroupedByProjectStatus() {

        List<ProjectStatusCountDto>  projectStatusCountDtos = projectsRepository.countProjectsGroupedByStatus();
        Long count = projectStatusCountDtos
                .stream()
                .distinct()
                .mapToLong(ProjectStatusCountDto::count)
                .sum();

        ProjectStatusCountDto projectStatusCountDto = new ProjectStatusCountDto(ProjectStatus.TOTAL, count);
        projectStatusCountDtos.add(projectStatusCountDto);
        return ResponseEntity.ok(projectStatusCountDtos);
    }

    @Override
    public Page<ProjectDto> getListOfProjects(Pageable pageable) {
        return projectsRepository.findAll(pageable).map(ProjectMapper::toDto);
    }

    @Override
    public ResponseEntity<ProjectDto> createProject(CreateProjectDto createProjectResponse) {

        Integer overallDays = (int) (ChronoUnit.DAYS.between(createProjectResponse.fromDate(), createProjectResponse.endDate()));
        System.out.println("Overall days: " + overallDays);
        Integer remainingDays;
        if (createProjectResponse.fromDate().isAfter(createProjectResponse.endDate()) ||
                createProjectResponse.fromDate().isEqual(createProjectResponse.endDate())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The startDate cannot be after endDate or equal to it!");
        }
        if (createProjectResponse.endDate().isAfter(LocalDate.now())) {
             remainingDays = (int) ChronoUnit.DAYS.between(LocalDate.now(), createProjectResponse.endDate());
        }else {
            Random random = new Random();
            remainingDays = random.nextInt(overallDays + 1);
        }


        Integer plannedRate = Math.min((100 / overallDays) * (overallDays - remainingDays), 100);

        Category category = categoryRepository.findByName(createProjectResponse.categoryDto().name());
        Project project = Project.builder()
                .name(createProjectResponse.name())
                .category(category)
                .revenue(createProjectResponse.revenue())
                .fromDate(createProjectResponse.fromDate())
                .endDate(createProjectResponse.endDate())
                .PMName(createProjectResponse.PMName())
                .remainingDays(remainingDays)
                .plannedRate(plannedRate)
                .status(ProjectStatus.NEW)
                .build();

        return ResponseEntity.ok(ProjectMapper.toDto(projectsRepository.save(project)));

    }

    @Override
    public ResponseEntity<ProjectDto> updateProject(UpdateProjectDto updateProjectDto) {
        Project oldProject = projectsRepository.findById(updateProjectDto.id())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Project with the given ID not found: " + updateProjectDto.id()
                ));

        Category category = categoryRepository.findByName(updateProjectDto.categoryDto().name());

        oldProject.setName(updateProjectDto.name());
        oldProject.setCategory(category);
        oldProject.setRevenue(updateProjectDto.revenue());
        oldProject.setFromDate(updateProjectDto.fromDate());
        oldProject.setEndDate(updateProjectDto.endDate());
        oldProject.setPMName(updateProjectDto.PMName());
        oldProject.setPlannedRate(updateProjectDto.plannedRate());
        oldProject.setActualRate(updateProjectDto.actualRate());
        oldProject.setStatus(updateProjectDto.status());

        return ResponseEntity.ok(ProjectMapper.toDto(projectsRepository.save(oldProject)));

    }

    @Override
    public String deleteProject(Long id) {
        Project project = projectsRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project with the given ID not found: " + id)
        );
        projectsRepository.deleteById(id);
        return "SUCCESS!";
    }

}
