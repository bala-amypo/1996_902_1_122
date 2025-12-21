package com.example.demo.controller;
import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public SaleTransaction createSale(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.createSale(transaction);
    }

    @GetMapping("/{id}")
    public SaleTransaction getSaleById(@PathVariable Long id) {
        return saleTransactionService.getSaleById(id);
    }

    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getSalesByCode(@PathVariable Long codeId) {
        return saleTransactionService.getSalesForCode(codeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getSalesByInfluencer(@PathVariable Long influencerId) {
        return saleTransactionService.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getSalesByCampaign(@PathVariable Long campaignId) {
        return saleTransactionService.getSalesForCampaign(campaignId);
    }
}
