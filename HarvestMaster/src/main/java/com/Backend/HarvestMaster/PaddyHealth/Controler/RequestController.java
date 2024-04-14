package com.Backend.HarvestMaster.PaddyHealth.Controler;

import com.Backend.HarvestMaster.PaddyHealth.Model.Request;
import com.Backend.HarvestMaster.PaddyHealth.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // Endpoint to get all field visit requests
    @GetMapping
    public List<Request> getAllFieldVisitRequests() {
        return requestService.getAllFieldVisitRequests();
    }

    // Endpoint to get a field visit request by its id
    @GetMapping("/{id}")
    public Optional<Request> getFieldVisitRequestById(@PathVariable Long id) {
        return requestService.getFieldVisitRequestById(id);
    }

    // Endpoint to add a new field visit request with date, time, and reply
    @PostMapping
    public Request addRequest(@RequestBody Request request) {
        return requestService.addRequest(request);
    }

    // Endpoint to update an existing field visit request with date, time, and reply
    @PutMapping("/{id}")
    public Request updateRequest(@PathVariable Long id, @RequestBody Request request) {
        return requestService.updateRequest(id, request);
    }

}
