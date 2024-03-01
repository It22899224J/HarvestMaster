package com.Backend.HarvestMaster.Farmer.Repository;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

}
