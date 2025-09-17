package tenzor.soft.test.dto;

import java.time.LocalDate;
import java.util.Locale.Category;

public record CreateProjectDto(

        String projectName,
        CategoryDto projectCategory,
        Integer salesRevenue,
        LocalDate fromDate,
        LocalDate endDate,
        Integer workdays,
        String PMName

) {

}
