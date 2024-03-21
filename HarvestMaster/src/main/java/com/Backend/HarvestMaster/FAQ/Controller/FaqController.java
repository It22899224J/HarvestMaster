package com.Backend.HarvestMaster.FAQ.Controller;


import com.Backend.HarvestMaster.FAQ.Model.FAQ;
import com.Backend.HarvestMaster.FAQ.Service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping ("/faq")
public class FaqController{


   @Autowired
   private FAQService faqService;



    @PostMapping ("/add")
    public ResponseEntity<FAQ> add(FAQ faq){

        try{

            FAQ current = faqService.addFaq(faq);
            return new ResponseEntity<>(current, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


    @GetMapping("/all")
    public ResponseEntity<List<FAQ>> get(){


        try {

            return new ResponseEntity<>(faqService.getAllFaq(),HttpStatus.OK);

        }catch (NoSuchElementException e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FAQ> update(@PathVariable Integer id) {

        try {


            faqService.removeFaq(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }

    }


}
