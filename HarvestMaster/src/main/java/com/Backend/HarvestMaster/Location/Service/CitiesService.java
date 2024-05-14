package com.Backend.HarvestMaster.Location.Service;

import com.Backend.HarvestMaster.Location.Model.Cities;
import java.util.List;

public interface CitiesService {
    List<Cities> getAllCitiesByDistrictId(Integer districtId);
}
