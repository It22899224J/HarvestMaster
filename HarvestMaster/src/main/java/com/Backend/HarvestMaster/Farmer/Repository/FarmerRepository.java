package com.Backend.HarvestMaster.Farmer.Repository;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

    Optional<Farmer> findByUserEmail(String email);
}
