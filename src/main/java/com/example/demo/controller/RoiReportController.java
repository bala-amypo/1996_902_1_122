package com.example.demo.controller;
import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/code/{codeId}")
    public RoiReport generateReportForCode(@PathVariable Long codeId) {
        return roiService.generateReportForCode(codeId);
    }

    @GetMapping("/{id}")
    public RoiReport getReportById(@PathVariable Long id) {
        return roiService.getReportById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getReportsByInfluencer(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }
}
