package com.Backend.HarvestMaster.Farmer.Controler;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Model.FarmerRegistrationRequest;
import com.Backend.HarvestMaster.Farmer.Service.FarmerService;
import com.Backend.HarvestMaster.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/farmer")
public class FarmerControler {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    public FarmerControler(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Farmer> registerFarmer(@RequestBody FarmerRegistrationRequest request) {
        User user = request.getUser();

        // Encrypt the password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Farmer createdFarmer = farmerService.createFarmer(user, request.getFarmer()); // Pass the updated user and farmer to the service method
        return new ResponseEntity<>(createdFarmer, HttpStatus.CREATED); // Return response
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<Farmer> getFarmerProfileByEmail(@PathVariable String email) {
        Farmer farmer = farmerService.getFarmerByEmail(email); // Call your service method to retrieve the farmer profile by email

        // Check if the farmer profile exists
        if (farmer != null) {
            return new ResponseEntity<>(farmer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping ("/profile/{id}")
    public ResponseEntity<Farmer> getProfileDetails(@PathVariable Integer id){

        try{

//            if(farmerService.deleteProfile(id)){
//
//                return new ResponseEntity<>(HttpStatus.OK);
//            }
//            else {
//                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//            }
            return null;
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
