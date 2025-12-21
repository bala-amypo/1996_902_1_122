package com.example.demo.service.impl;

import com.example.demo.entity.DiscountCode;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    public DiscountCodeServiceImpl(
            DiscountCodeRepository repository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository) {
        this.repository = repository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {
        if (code.getDiscountPercentage() < 0 || code.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("Discount percentage invalid");
        }
        return repository.save(code);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {
        DiscountCode existing = getDiscountCodeById(id);
        existing.setCode(code.getCode());
        existing.setDiscountPercentage(code.getDiscountPercentage());
        return repository.save(existing);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discount code not found"));
    }

    @Override
    public List<DiscountCode> getCodesByInfluencer(Long influencerId) {
        return repository.findByInfluencer_Id(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesByCampaign(Long campaignId) {
        return repository.findByCampaign_Id(campaignId);
    }

    @Override
    public void deactivateCode(Long id) {
        DiscountCode code = getDiscountCodeById(id);
        code.setActive(false);
        repository.save(code);
    }
}
