package tenzor.soft.test.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import tenzor.soft.test.dto.dashboard.*;
import tenzor.soft.test.repository.ProjectsRepository;
import tenzor.soft.test.service.ReportsService;

@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportsService {


    private final ProjectsRepository projectsRepository;

    @Override
    public ResponseEntity<List<MonthlySalesRevenueDashboardResponseDto>> getRevenueResponse(Long year) {
        return ResponseEntity.ok(projectsRepository.getMonthlySalesRevenue(year));
    }

    @Override
    public ResponseEntity<RevenueByProjectTypeDashboardDto> getBusinessTypeDashboard(Long year) {
        if (year < 2024 || year > 2026 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ONLY 2024-2025 is available");
        }
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
        return ResponseEntity.ok(projectsRepository.getHighestDelayedProjects(year));
    }

    @Override
    public ResponseEntity<List<ProjectMonthlySalesDto>> getProjectMonthlySales(Long projectId) {
        projectsRepository.findById(projectId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found")
        );
        return ResponseEntity.ok(projectsRepository.getMonthlySalesByProject(projectId));
    }


}
