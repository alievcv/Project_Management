package tenzor.soft.test.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tenzor.soft.test.dto.dashboard.*;
import tenzor.soft.test.repository.ProjectsRepository;
import tenzor.soft.test.service.ReportsService;

@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportsService {


    private final ProjectsRepository projectsRepository;

    @Override
    public ResponseEntity<List<MonthlySalesRevenueResponseDto>> getRevenueResponse(Long year) {
        return ResponseEntity.ok(projectsRepository.getMonthlySalesRevenue(year));
    }

    @Override
    public ResponseEntity<RevenueByProjectTypeDashboardDto> getBusinessTypeDashboard(Long year) {
        List<RevenueByProjectType> percentagesByProjectType = projectsRepository.getRevenuePercentagesByProjectType(year); //1
        List<SICategoryTopFourProjects> topFourSI = projectsRepository.getTopFourFromSICategory(year);//2
        List<SMCategoryTopFourProjects> topFourSM = projectsRepository.getTopFourFromSMCategory(year);//3

        //Adashmaslik uchun alohida DTO qilsa ham bo'lar edi
        return ResponseEntity.ok(
                new RevenueByProjectTypeDashboardDto(percentagesByProjectType, topFourSI, topFourSM
                ));
    }

    @Override
    public ResponseEntity<KeyPerformanceIndicatorResponseDto> getPerformanceIndicatorResponse(Long year, Long goal) {
        return ResponseEntity.ok(projectsRepository.getKPIDashboard(year, goal));
    }


    @Override
    public ResponseEntity<List<DelayedPMResponseDto>> getDelayedPMResponse(Long year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDelayedPMResponse'");
    }

    @Override
    public ResponseEntity<ProjectMonthlySalesDto> getProjectMonthlySales(Long projectId) {
        return null;
    }


}
