package com.Backend.HarvestMaster.FinancialManager.Controller;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.Farmer.Model.FarmerRegistrationRequest;
import com.Backend.HarvestMaster.FinancialManager.Model.FinancialManager;
import com.Backend.HarvestMaster.FinancialManager.Model.FinancialManagerRegistrationRequest;
import com.Backend.HarvestMaster.FinancialManager.Service.FinancialManagerService;
import com.Backend.HarvestMaster.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-manager")
public class FinancialManagerController {
    @Autowired
    FinancialManagerService financialManagerService;

    @PostMapping("/register")
    public ResponseEntity<FinancialManager> registerFinancialManager(@RequestBody FinancialManagerRegistrationRequest request) {
        User user = request.getUser();

        // Encrypt the password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        FinancialManager createdFinancialManager = financialManagerService.createFinancialManager(user, request.getFinancialManager());
        return new ResponseEntity<>(createdFinancialManager, HttpStatus.CREATED); // Return response
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<FinancialManager> getFinancialManagerProfileByEmail(@PathVariable String email) {
        FinancialManager financialManager = financialManagerService.getFinancialManagerByEmail(email);

        // Check if the farmer profile exists
        if (financialManager != null) {
            return new ResponseEntity<>(financialManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
