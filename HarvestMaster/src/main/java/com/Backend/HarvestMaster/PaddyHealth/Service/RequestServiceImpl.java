package com.Backend.HarvestMaster.PaddyHealth.Service;
import com.Backend.HarvestMaster.PaddyHealth.Model.Request;
import com.Backend.HarvestMaster.PaddyHealth.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:5173/")
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    // Method to create a new request
    @Override
    public Request createRequest(Request request) {
        request.setStatus("Pending");
        return requestRepository.save(request);
    }

    // Method to accept a request by its ID
    @Override
    public Request acceptRequest(Long id) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setStatus("Accepted");
            return requestRepository.save(request);
        }
        return null;
    }

    // Method to schedule a visit for a request by its ID and scheduled time
    @Override
    public ResponseEntity<?> scheduleVisit(Long id, String scheduledTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime parsedScheduledDateTime = LocalDateTime.parse(scheduledTime, formatter);

            Optional<Request> optionalRequest = requestRepository.findById(id);
            if (optionalRequest.isPresent()) {
                Request request = optionalRequest.get();
                request.setScheduledTime(parsedScheduledDateTime);
                request.setStatus("Scheduled");
                requestRepository.save(request);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Return an error response if scheduling fails
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error scheduling visit: " + e.getMessage());
        }
    }

    // Method to retrieve requests by their status
    @Override
    public List<Request> getRequestsByStatus(String status) {
        return requestRepository.findByStatus(status);
    }

    // Method to retrieve a request by its ID
    @Override
    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    // Method to update an existing request
    @Override
    public void updateRequest(Request request) {
        requestRepository.save(request);
    }
}
