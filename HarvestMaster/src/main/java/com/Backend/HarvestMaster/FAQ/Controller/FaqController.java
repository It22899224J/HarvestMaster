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

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping ("/faq")
public class FaqController{


   @Autowired
   private FAQService faqService;



    @PostMapping ("/add")
    public ResponseEntity<FAQ> add(@RequestBody FAQ faq){

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

            return new ResponseEntity<>(faqService.getAllFaqs(),HttpStatus.OK);

        }catch (NoSuchElementException e){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody FAQ faq) {

        try {

            FAQ current = faqService.getSelectedFaq(id);

            faq.setFaq_id(current.getFaq_id());


            return new ResponseEntity<FAQ>(faqService.addFaq(faq),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFaq(@PathVariable Integer id) {

        try {


            faqService.removeFaq(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }

    }


}
