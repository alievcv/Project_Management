package tenzor.soft.test.dto.dashboard;

public record KeyPerformanceIndicatorResponseDto(
        Long totalRevenue,
        Long annualGole,
        Long achievedPercent,
        Long remainingRevenue
) {

}
