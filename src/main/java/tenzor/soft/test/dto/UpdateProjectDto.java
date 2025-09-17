package tenzor.soft.test.dto;

import tenzor.soft.test.enums.ProjectStatus;

import java.time.LocalDate;

public record UpdateProjectDto(
        Long id,
        String name,
        CategoryDto categoryDto,
        Integer revenue,
        LocalDate fromDate,
        LocalDate endDate,
        Integer remainingDats,
        String PMName,
        Integer plannedRate,
        Integer actualRate,
        ProjectStatus status
) {

}
