package tenzor.soft.test.service;

import java.util.List;

import tenzor.soft.test.dto.dashboard.BusinessTypeResponseDto;
import tenzor.soft.test.dto.dashboard.DelayedPMResponseDto;
import tenzor.soft.test.dto.dashboard.KeyPerformanceIndicatorResponseDto;
import tenzor.soft.test.dto.dashboard.SalesRevenueResponseDto;

public interface ReportsService {
    List<BusinessTypeResponseDto> getBusinessTypeDashboard(Integer year);

    List<DelayedPMResponseDto> getDelayedPMResponse(Integer year);

    List<KeyPerformanceIndicatorResponseDto> getPerformanceIndicatorResponse(Integer year);

    List<SalesRevenueResponseDto> getRevenueResponse(Integer year);
}
