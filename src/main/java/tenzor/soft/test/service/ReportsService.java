package tenzor.soft.test.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import tenzor.soft.test.dto.dashboard.*;

public interface ReportsService {

    ResponseEntity<List<MonthlySalesRevenueResponseDto>> getRevenueResponse(Long year);

    ResponseEntity<RevenueByProjectTypeDashboardDto> getBusinessTypeDashboard(Long year);

    ResponseEntity<KeyPerformanceIndicatorResponseDto> getPerformanceIndicatorResponse(Long year, Long goal);

    ResponseEntity<List<DelayedPMResponseDto>> getDelayedPMResponse(Long year);

    ResponseEntity<ProjectMonthlySalesDto> getProjectMonthlySales(Long projectId);
}
