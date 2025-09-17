package tenzor.soft.test.dto;

import tenzor.soft.test.enums.ProjectStatus;

import java.time.LocalDate;

public record ProjectDto(

        Long id,
        String name,
        CategoryDto categoryDto,
        Integer revenue,
        LocalDate fromDate,
        LocalDate endDate,
        Integer remainingDays,
        String PMName,
        Integer planedRate,
        Integer actualRate,
        ProjectStatus status

) {

}
