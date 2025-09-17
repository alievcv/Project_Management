package tenzor.soft.test.dto.dashboard;

public record ProjectMonthlySalesDto (
    String monthName,
    Long monthlyRevenue,
    Long totalRevenue
)
{
}
