package com.Backend.HarvestMaster.Authentication.Controler;


import com.Backend.HarvestMaster.Authentication.Service.AuthService;
import com.Backend.HarvestMaster.Authentication.model.Auth;
import com.Backend.HarvestMaster.Authentication.model.AuthResponse;
import com.Backend.HarvestMaster.Authentication.model.UserDetails;
import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/user")
public class AuthControler {



    @Autowired
    private FarmerService farmerService;

    @Autowired
    private AuthService authService;

    //login check and jwt auth
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> check(@RequestBody Auth auth){

        try{
            if (auth.getEmail() == null){

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Farmer current = farmerService.authCheck(auth.getEmail());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            if (auth.getPassword() == null){

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            //password check(incoming password with hashed one )
            if(bCryptPasswordEncoder.matches(auth.getPassword(),current.getPassword())){

                 UserDetails userDetails = new UserDetails(current.getId(),current.getEmail(),current.getName());

                final String jwt = authService.jwtAuth(userDetails);

                AuthResponse token = new AuthResponse(current.getName(),jwt);

                return new ResponseEntity<AuthResponse>(token,HttpStatus.OK);

            }
            else{

                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }
        catch (NoSuchElementException e)
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
