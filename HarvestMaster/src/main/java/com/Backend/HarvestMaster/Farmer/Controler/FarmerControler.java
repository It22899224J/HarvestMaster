package com.Backend.HarvestMaster.Farmer.Controler;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        farmerService.signUpDetails(details);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login")

    public ResponseEntity<Farmer> check(@RequestBody Integer id,@RequestBody String password){

        try{
            if (id == null){

                return new ResponseEntity<Farmer>(HttpStatus.BAD_REQUEST);
            }

            Farmer current = farmerService.profileDetails(id);

            if (password == null){

                return new ResponseEntity<Farmer>(HttpStatus.BAD_REQUEST);
            }

            if(current.getPassword() == password){

                return new ResponseEntity<>(HttpStatus.OK);

            }
            else{

                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }
        catch (NoSuchElementException e)
        {
            return  new ResponseEntity<Farmer>(HttpStatus.NOT_FOUND);
        }

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
