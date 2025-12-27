package com.example.demo.repository;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.Campaign;
import com.example.demo.model.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {

    List<DiscountCode> findByInfluencer(Influencer influencer);

    List<DiscountCode> findByCampaign(Campaign campaign);

    boolean existsByCodeValue(String codeValue);
}
