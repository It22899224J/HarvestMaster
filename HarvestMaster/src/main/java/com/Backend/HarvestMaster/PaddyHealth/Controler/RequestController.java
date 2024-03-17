package com.Backend.HarvestMaster.PaddyHealth.Controler;
import com.Backend.HarvestMaster.PaddyHealth.Model.Request;
import com.Backend.HarvestMaster.PaddyHealth.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Create a new request
    @PostMapping
    public ResponseEntity<String> createRequest(@RequestBody Request request) {
        Request createdRequest = requestService.createRequest(request);
        if (createdRequest != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Visit form added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add visit form");
        }
    }

    // Accept a request with a specific ID
    @PutMapping("/{id}/accept")
    public Request acceptRequest(@PathVariable Long id) {
        return requestService.acceptRequest(id);
    }

    // Endpoint to schedule a visit for a request with a specific ID
    @PutMapping("/{id}/schedule")
    public ResponseEntity<?> scheduleVisit(@PathVariable Long id, @RequestParam("scheduledTime") LocalDateTime scheduledTime) {
        try {
            // Update request's status to "Scheduled" and save scheduled date and time in the database
            Optional<Request> optionalRequest = requestService.getRequestById(id);
            if (optionalRequest.isPresent()) {
                Request request = optionalRequest.get();
                request.setScheduledTime(scheduledTime);
                request.setStatus("Scheduled");
                requestService.updateRequest(request);
                return ResponseEntity.ok("Time added successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error scheduling visit: " + e.getMessage());
        }
    }

    // GET requests to retrieve pending requests
    @GetMapping("/pending")
    public List<Request> getPendingRequests() {
        return requestService.getRequestsByStatus("Pending");
    }

    // GET requests to retrieve accepted requests
    @GetMapping("/accepted")
    public List<Request> getAcceptedRequests() {
        return requestService.getRequestsByStatus("Accepted");
    }

    // GET requests to retrieve scheduled visits
    @GetMapping("/scheduled")
    public List<Request> getScheduledVisits() {
        return requestService.getRequestsByStatus("Scheduled");
    }
}
