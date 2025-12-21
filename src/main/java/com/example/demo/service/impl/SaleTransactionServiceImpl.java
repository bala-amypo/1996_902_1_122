package com.example.demo.service.impl;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repository;
    private final DiscountCodeRepository discountCodeRepository;

    public SaleTransactionServiceImpl(
            SaleTransactionRepository repository,
            DiscountCodeRepository discountCodeRepository) {
        this.repository = repository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction logTransaction(SaleTransaction transaction) {
        if (transaction.getSaleAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        if (!discountCodeRepository.existsById(
                transaction.getDiscountCode().getId())) {
            throw new EntityNotFoundException("Discount code not found");
        }

        return repository.save(transaction);
    }

    @Override
    public SaleTransaction getTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long codeId) {
        return repository.findByDiscountCode_Id(codeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return repository.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return repository.findByDiscountCode_Campaign_Id(campaignId);
    }
}
