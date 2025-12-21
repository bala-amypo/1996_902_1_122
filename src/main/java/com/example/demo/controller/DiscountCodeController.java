package com.example.demo.controller;
import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode code) {
        return discountCodeService.createDiscountCode(code);
    }

    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(@PathVariable Long id,
                                           @RequestBody DiscountCode code) {
        return discountCodeService.updateDiscountCode(id, code);
    }

    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getCodesByInfluencer(@PathVariable Long influencerId) {
        return discountCodeService.getCodesByInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getCodesByCampaign(@PathVariable Long campaignId) {
        return discountCodeService.getCodesByCampaign(campaignId);
    }
}
