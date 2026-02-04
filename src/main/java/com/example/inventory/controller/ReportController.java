package com.example.inventory.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> report() {
        Map<String, Object> map = new HashMap<>();
        map.put("totalProducts", service.totalProducts());
        map.put("totalStock", service.totalStock());
        map.put("lowStock", service.lowStockCount());
        return map;
    }
}
