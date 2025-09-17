package tenzor.soft.test.dto;

import java.time.LocalDate;
import java.util.Locale.Category;

public record CreateProjectDto(

        String name,
        CategoryDto categoryDto,
        Integer revenue,
        LocalDate fromDate,
        LocalDate endDate,
        Integer remainingDays,
        String PMName

) {

}
