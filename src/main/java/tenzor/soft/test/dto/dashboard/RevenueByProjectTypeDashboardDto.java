package tenzor.soft.test.dto.dashboard;

import java.util.List;

public record RevenueByProjectTypeDashboardDto(
        List<RevenueByProjectType> SmAndSiPercentages,
        List<SICategoryTopFourProjects> TopFourSI,
        List<SMCategoryTopFourProjects> TOPFourSM

){
}
