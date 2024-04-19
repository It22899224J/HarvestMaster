package com.Backend.HarvestMaster.Buyer.Repositiory;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepositiory extends JpaRepository<Buyer, Integer> {
    Buyer findById(Long cusId);
}
