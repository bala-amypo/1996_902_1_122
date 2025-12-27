package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository discountCodeRepository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository) {
        this.discountCodeRepository = discountCodeRepository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        existing.setCodeValue(discountCode.getCodeValue());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());

        return discountCodeRepository.save(existing);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        Influencer influencer = influencerRepository.findById(influencerId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return discountCodeRepository.findByInfluencer(influencer);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return discountCodeRepository.findByCampaign(campaign);
    }
}
