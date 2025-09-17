package tenzor.soft.test.mapper;

import org.springframework.stereotype.Component;

import tenzor.soft.test.dto.ProjectDto;
import tenzor.soft.test.entity.Project;

@Component
public class ProjectMapper {

    public static ProjectDto toDto(Project project) {
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getRevenue(),
                project.getFromDate(),
                project.getEndDate(),
                project.getRemainingDays(),
                project.getPMName(),
                project.getPlannedRate(),
                project.getActualRate(),
                project.getStatus());
    }

}
