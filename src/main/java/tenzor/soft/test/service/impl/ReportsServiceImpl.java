package tenzor.soft.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tenzor.soft.test.dto.dashboard.BusinessTypeResponseDto;
import tenzor.soft.test.dto.dashboard.DelayedPMResponseDto;
import tenzor.soft.test.dto.dashboard.KeyPerformanceIndicatorResponseDto;
import tenzor.soft.test.dto.dashboard.SalesRevenueResponseDto;
import tenzor.soft.test.service.ReportsService;

@Service
public class ReportsServiceImpl implements ReportsService {

    @Override
    public List<BusinessTypeResponseDto> getBusinessTypeDashboard(Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBusinessTypeDashboard'");
    }

    @Override
    public List<DelayedPMResponseDto> getDelayedPMResponse(Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDelayedPMResponse'");
    }

    @Override
    public List<KeyPerformanceIndicatorResponseDto> getPerformanceIndicatorResponse(Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPerformanceIndicatorResponse'");
    }

    @Override
    public List<SalesRevenueResponseDto> getRevenueResponse(Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRevenueResponse'");
    }

}
