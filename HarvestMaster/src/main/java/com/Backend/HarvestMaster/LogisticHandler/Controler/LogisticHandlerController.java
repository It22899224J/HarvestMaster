package com.Backend.HarvestMaster.LogisticHandler.Controler;

import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandler;
import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandlerRequest;
import com.Backend.HarvestMaster.LogisticHandler.Service.LogisticHandlerService;
import com.Backend.HarvestMaster.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logistic")
public class LogisticHandlerController {
    @Autowired
    LogisticHandlerService logisticHandlerService;

    @PostMapping("/register")
    public ResponseEntity<LogisticHandler> registerLogisticHandler(@RequestBody LogisticHandlerRequest request) {
        User user = request.getUser();

        // Encrypt the password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        LogisticHandler createdLogisticHandler = logisticHandlerService.createLogisticHandler(user, request.getLogisticHandler());
        return new ResponseEntity<>(createdLogisticHandler, HttpStatus.CREATED); // Return response
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<LogisticHandler> getLogisticHandlerByEmail(@PathVariable String email) {
        LogisticHandler logisticHandler = logisticHandlerService.getLogisticHandlerByEmail(email);

        if (logisticHandler != null) {
            return new ResponseEntity<>(logisticHandler, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
