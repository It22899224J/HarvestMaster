package com.Backend.HarvestMaster.Authentication.Controler;


import com.Backend.HarvestMaster.Authentication.model.Auth;
import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class AuthControler {



    @Autowired
    private FarmerService farmerService;

    //login check and jwt auth
    @PostMapping("/login")
    public ResponseEntity<Farmer> check(@RequestBody Auth auth){

        try{
            if (auth.getUserName() == null){

                return new ResponseEntity<Farmer>(HttpStatus.BAD_REQUEST);
            }

            Farmer current = farmerService.authCheck(auth.getUserName());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            if (auth.getPassword() == null){

                return new ResponseEntity<Farmer>(HttpStatus.BAD_REQUEST);
            }

            //password check(incoming password with hashed one )
            if(bCryptPasswordEncoder.matches(auth.getPassword(),current.getPassword())){

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

}
