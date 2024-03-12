package com.Backend.HarvestMaster.LogisticHandler.Controler;

import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandler;
import com.Backend.HarvestMaster.LogisticHandler.Repository.LogisticHandlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticHandlerControler{
    @Autowired
    private LogisticHandlerRepository logisticHandlerRepository;

    @PostMapping("/LogisticHandler")
    LogisticHandler newLogisticHandler(@RequestBody LogisticHandler newLogisticHandler){
        return LogisticHandlerRepository.save(newLogisticHandler);
    }


}
