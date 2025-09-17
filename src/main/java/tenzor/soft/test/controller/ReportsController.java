package tenzor.soft.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tenzor.soft.test.dto.dashboard.*;
import tenzor.soft.test.service.ReportsService;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {

    private final ReportsService reportsService;


    @GetMapping("/monthlyRevenueDashboard")
    public ResponseEntity<List<MonthlySalesRevenueDashboardResponseDto>> getMonthlySalesRevenue(@RequestParam Long year) {
        return reportsService.getRevenueResponse(year);
    }

    @GetMapping("/revenueBusinessType")
    public ResponseEntity<RevenueByProjectTypeDashboardDto> getRevenueByBusinessType(@RequestParam Long year) {
        return reportsService.getBusinessTypeDashboard(year);
    }

    @GetMapping("/kpi")
    public ResponseEntity<KeyPerformanceIndicatorResponseDto> getKpiDashboard(@RequestParam Long year, @RequestParam Long goal) {
        return reportsService.getPerformanceIndicatorResponse(year, goal
        );
    }

    @GetMapping("/mostDelayedProjects")
    public ResponseEntity<List<DelayedPMResponseDto>> getDelayedProjects(@RequestParam Long year) {
        return reportsService.getDelayedPMResponse(year);
    }

    @GetMapping("/projectMonthlySales")
    public ResponseEntity<List<ProjectMonthlySalesDto>> getMonthlySales(@RequestParam Long projectId) {
        return reportsService.getProjectMonthlySales(projectId);
    }


}
