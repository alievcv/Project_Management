package tenzor.soft.test.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tenzor.soft.test.enums.ProjectStatus;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Integer revenue;
    private LocalDate fromDate;
    private LocalDate endDate;
    private Integer remainingDays;
    private String PMName;

    @Min(value = 0)
    @Max(value = 100)
    private Integer plannedRate;

    @Min(value = 0)
    @Max(value = 100)
    private Integer actualRate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status; //delayed, ongoing, planned, finished


}
