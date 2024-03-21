//package com.Backend.HarvestMaster.LogisticHandler.Controler;
//
//import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandler;
//import com.Backend.HarvestMaster.LogisticHandler.Repository.LogisticHandlerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@RestController
//@RequestMapping("/logistic")
//public class LogisticHandlerControler{
//    @Autowired
//    private LogisticHandlerRepository logisticHandlerRepository;
//
//    @PostMapping("/add")
//    public ResponseEntity<LogisticHandler> newLogisticHandler(@RequestBody LogisticHandler newLogisticHandler){
//
//
//        try {
//
//
//            return new ResponseEntity<>(logisticHandlerRepository.save(newLogisticHandler), HttpStatus.OK);
//        }catch (NoSuchElementException e){
//
//            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//
//    }
//
//
////    @GetMapping("/LogisticHandlers")
////    List<LogisticHandler> getallusers{
////        return LogisticHandlerRepository.findAll();
////    }
//
//
//
//
//}
