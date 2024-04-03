package com.Backend.HarvestMaster.Authentication.Controler;


import com.Backend.HarvestMaster.Authentication.model.LoginRequest;
import com.Backend.HarvestMaster.Authentication.model.LoginResponse;
import com.Backend.HarvestMaster.User.Model.USER_ROLES;
import com.Backend.HarvestMaster.User.Model.User;
import com.Backend.HarvestMaster.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/user")
public class AuthControler {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();


        String token = userService.login(email, password);
        if (token != null) {
            // If authentication is successful, return JWT token
            User userDetails = userService.getUserByEmail(email);

            USER_ROLES userRole = userService.getUserRole(email);

//            Farmer farmerDetails = farmerService.getFarmerByUserId(userDetails.getId());

            LoginResponse response = new LoginResponse(token, userDetails, userRole);
            return ResponseEntity.ok(response);
        } else {
            // If authentication fails, return unauthorized status
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            return null;
        }
    }
}