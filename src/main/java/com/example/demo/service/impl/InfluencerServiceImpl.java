package com.example.demo.service.impl;

import com.example.demo.entity.Influencer;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.DuplicateEntityException;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository repository;

    public InfluencerServiceImpl(InfluencerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        if (repository.findBySocialHandle(influencer.getSocialHandle()).isPresent()) {
            throw new DuplicateEntityException("Influencer already exists");
        }
        return repository.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = getInfluencerById(id);
        existing.setName(influencer.getName());
        existing.setEmail(influencer.getEmail());
        return repository.save(existing);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Influencer not found"));
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return repository.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        influencer.setActive(false);
        repository.save(influencer);
    }
}
