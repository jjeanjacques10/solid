package com.jjeanjacques.solidbad.controller;

import com.jjeanjacques.solidbad.controller.dto.ReportCatchDTO;
import com.jjeanjacques.solidbad.controller.dto.ReportDTO;
import com.jjeanjacques.solidbad.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    PokedexService pokedexService;

    @GetMapping("/catch")
    public ResponseEntity<ReportCatchDTO> catchReport() {
        var report = pokedexService.showCatch();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<ReportDTO> printReport() {
        var report = pokedexService.printReport();
        return ResponseEntity.ok(report);
    }

}
