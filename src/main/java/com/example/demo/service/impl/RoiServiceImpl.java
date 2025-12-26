package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {
        return null;
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        return null;
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return null;
    }
}
