package com.Backend.HarvestMaster.SupportPersonnel.Controller;


import com.Backend.HarvestMaster.SupportPersonnel.Model.SupportPersonnel;
import com.Backend.HarvestMaster.SupportPersonnel.Service.SupportPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/suppotpersonnel")
public class SupportPersonnelController {

    @Autowired
    private SupportPersonnelService supportPersonnelService;

    @PostMapping("/add")
    public ResponseEntity<SupportPersonnel> add(SupportPersonnel supportPersonnel){

        try{

            return new ResponseEntity<>(supportPersonnel, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
