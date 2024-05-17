package com.Backend.HarvestMaster.Location.Controller;

import com.Backend.HarvestMaster.Location.Model.Cities;
import com.Backend.HarvestMaster.Location.Model.Districts;
import com.Backend.HarvestMaster.Location.Service.CitiesService;
import com.Backend.HarvestMaster.Location.Service.DistrictsService;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    DistrictsService districtsService;
    @Autowired
    CitiesService citiesService;

    @GetMapping("/getAllDistricts/{provinceId}")
    public ResponseEntity<?> getDistrictsByProvinceId(@PathVariable Integer provinceId){
        try{
            List<Districts> districts = districtsService.getAllDistrictsByProvinceId(provinceId);
            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve districts", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllCities/{districtId}")
    public ResponseEntity<?> getCitiesByDistrictId(@PathVariable Integer districtId){
        try{
            List<Cities> cities = citiesService.getAllCitiesByDistrictId(districtId);
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve cities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
