package tenzor.soft.test.dto.dashboard;

public record KeyPerformanceIndicatorResponseDto(
        Long totalRevenue,
        Long annualGoal,
        Long achievedPercent,
        Long remainingRevenue
) {

}
