package tenzor.soft.test.service;

import java.util.List;

import tenzor.soft.test.dto.dashboard.*;

public interface ReportsService {

    List<SalesRevenueResponseDto> getRevenueResponse(Integer year);

    List<BusinessTypeResponseDto> getBusinessTypeDashboard(Integer year);

    List<KeyPerformanceIndicatorResponseDto> getPerformanceIndicatorResponse(Integer year);

    List<DelayedPMResponseDto> getDelayedPMResponse(Integer year);

    ProjectMonthlySalesDto getProjectMonthlySales(Long projectId);
}
