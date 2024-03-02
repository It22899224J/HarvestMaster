package com.Backend.HarvestMaster.Farmer.Repository;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {


    Farmer findByname(String userName);
}
