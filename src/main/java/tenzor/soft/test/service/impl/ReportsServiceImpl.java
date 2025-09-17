package tenzor.soft.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tenzor.soft.test.dto.dashboard.*;
import tenzor.soft.test.service.ReportsService;

@Service
public class ReportsServiceImpl implements ReportsService {


    @Override
    public List<SalesRevenueResponseDto> getRevenueResponse(Integer year) {

        return null;
    }

    @Override
    public List<BusinessTypeResponseDto> getBusinessTypeDashboard(Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBusinessTypeDashboard'");
    }

    @Override
    public List<KeyPerformanceIndicatorResponseDto> getPerformanceIndicatorResponse(Integer year) {
        // TODO Auto-generted method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPerformanceIndicatorResponse'");
    }


    @Override
    public List<DelayedPMResponseDto> getDelayedPMResponse(Integer year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDelayedPMResponse'");
    }

    @Override
    public ProjectMonthlySalesDto getProjectMonthlySales(Long projectId) {
        return null;
    }


}
