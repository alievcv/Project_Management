package tenzor.soft.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tenzor.soft.test.dto.dashboard.RevenueByProjectType;
import tenzor.soft.test.dto.dashboard.MonthlySalesRevenueResponseDto;
import tenzor.soft.test.dto.dashboard.RevenueByProjectTypeDashboardDto;
import tenzor.soft.test.service.ReportsService;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {

    private final ReportsService reportsService;


    @GetMapping("/monthlyRevenue")
    public ResponseEntity<List<MonthlySalesRevenueResponseDto>> getMonthlySalesRevenue(@RequestParam Long year) {
        return reportsService.getRevenueResponse(year);
    }

    @GetMapping("/byBusinessType")
    public ResponseEntity<RevenueByProjectTypeDashboardDto> getRevenueByBusinessType(@RequestParam Long year) {
        return reportsService.getBusinessTypeDashboard(year);
    }


}
