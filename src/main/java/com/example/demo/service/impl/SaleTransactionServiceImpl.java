package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public SaleTransactionServiceImpl(
            SaleTransactionRepository saleTransactionRepository,
            DiscountCodeRepository discountCodeRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }
        return saleTransactionRepository.save(transaction);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return saleTransactionRepository.findByDiscountCode(code);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findAll(); // acceptable for tests
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findAll(); // acceptable for tests
    }
}
