package com.Backend.HarvestMaster.Location.Service;

import com.Backend.HarvestMaster.Location.Model.Districts;
import java.util.List;

public interface DistrictsService {
    List<Districts> getAllDistrictsByProvinceId(Integer provinceId);
    Districts getDistrictById(Integer districtId);
}
