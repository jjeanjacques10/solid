package com.jjeanjacques.solidgood.controller;

import com.jjeanjacques.solidgood.controller.dto.ReportCatchDTO;
import com.jjeanjacques.solidgood.controller.dto.ReportDTO;
import com.jjeanjacques.solidgood.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/catch")
    public ResponseEntity<ReportCatchDTO> catchReport() {
        var report = reportService.showCatch();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<ReportDTO> printReport(@PathVariable int year, @PathVariable int month) {
        var report = reportService.printReport(year, month);
        return ResponseEntity.ok(report);
    }

}
