package com.example.demo.service.impl;

import com.example.demo.entity.DiscountCode;
import com.example.demo.entity.RoiReport;
import com.example.demo.entity.SaleTransaction;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiRepository;
    private final SaleTransactionRepository saleRepository;
    private final DiscountCodeRepository codeRepository;

    public RoiServiceImpl(
            RoiReportRepository roiRepository,
            SaleTransactionRepository saleRepository,
            DiscountCodeRepository codeRepository) {
        this.roiRepository = roiRepository;
        this.saleRepository = saleRepository;
        this.codeRepository = codeRepository;
    }

    @Override
    public RoiReport generateRoiForCode(Long codeId) {
        DiscountCode code = codeRepository.findById(codeId)
                .orElseThrow(() -> new EntityNotFoundException("Discount code not found"));

        List<SaleTransaction> sales = saleRepository.findByDiscountCode_Id(codeId);

        BigDecimal totalSales = sales.stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        RoiReport report = new RoiReport();
        report.setCampaign(code.getCampaign());
        report.setInfluencer(code.getInfluencer());
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalSales);
        report.setRoiPercentage(BigDecimal.valueOf(100));

        return roiRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiRepository.findByInfluencer_Id(influencerId);
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiRepository.findByCampaign_Id(campaignId);
    }
}
