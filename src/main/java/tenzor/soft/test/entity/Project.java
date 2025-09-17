package tenzor.soft.test.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    private String status;

}
