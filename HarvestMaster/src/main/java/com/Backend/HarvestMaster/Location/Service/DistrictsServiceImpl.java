package com.Backend.HarvestMaster.Location.Service;

import com.Backend.HarvestMaster.Location.Model.Districts;
import com.Backend.HarvestMaster.Location.Repository.DistrictsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictsServiceImpl implements DistrictsService{

    @Autowired
    private DistrictsRepository districtsRepository;
    @Override
    public List<Districts> getAllDistrictsByProvinceId(Integer provinceId) {
        return districtsRepository.findByProvinceId(provinceId);
    }

    @Override
    public Districts getDistrictById(Integer districtId) {
        return districtsRepository.findById(districtId).get();
    }
}
