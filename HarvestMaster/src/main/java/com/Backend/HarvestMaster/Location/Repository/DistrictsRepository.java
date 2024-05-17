package com.Backend.HarvestMaster.Location.Repository;

import com.Backend.HarvestMaster.Location.Model.Cities;
import com.Backend.HarvestMaster.Location.Model.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictsRepository extends JpaRepository <Districts,Integer>{
    List<Districts> findByProvinceId(Integer provinceId);
}