package com.example.demo.controller;
import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @PostMapping
    public Influencer createInfluencer(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    @GetMapping("/{id}")
    public Influencer getInfluencerById(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }

    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return influencerService.getAllInfluencers();
    }
}
