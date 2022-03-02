package com.jjeanjacques.solidgood.service;

import com.jjeanjacques.solidgood.controller.dto.ReportCatchDTO;
import com.jjeanjacques.solidgood.controller.dto.ReportDTO;

public interface ReportService {

    ReportDTO printReport(int month, int year) ;
    ReportCatchDTO showCatch();

}
