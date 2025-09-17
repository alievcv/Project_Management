package tenzor.soft.test.dto;

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
                String status

) {

}
