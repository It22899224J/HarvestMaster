package com.Backend.HarvestMaster.Farmer.Controler;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Service.FarmerService;
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


    //signup details
    @PostMapping("/add")
    public ResponseEntity addFarmer(@RequestBody Farmer details){

        //encodeing incomming passwords
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        details.setPassword(bCryptPasswordEncoder.encode(details.getPassword()));

        farmerService.signUpDetails(details);
        return new ResponseEntity<>(HttpStatus.OK);
    }




    @DeleteMapping ("/profile/{id}")
    public ResponseEntity<Farmer> getProfileDetails(@PathVariable Integer id){

        try{

            if(farmerService.deleteProfile(id)){

                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
