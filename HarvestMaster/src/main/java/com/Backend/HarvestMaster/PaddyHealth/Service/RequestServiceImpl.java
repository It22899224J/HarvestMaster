package com.Backend.HarvestMaster.PaddyHealth.Service;

import com.Backend.HarvestMaster.PaddyHealth.Model.Request;
import com.Backend.HarvestMaster.PaddyHealth.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    // Method to retrieve all field visit requests
    @Override
    public List<Request> getAllFieldVisitRequests() {
        return requestRepository.findAll();
    }

    // Method to retrieve a field visit request by its id
    @Override
    public Optional<Request> getFieldVisitRequestById(Long id) {
        return requestRepository.findById(id);
    }

    // Method to add a new field visit request with date, time, and reply
    @Override
    public Request addRequest(Request request) {
        // Validate visitDateTime and reply
        if (request.getVisitDateTime() == null || request.getReply() == null || request.getReply().isEmpty()) {
            throw new IllegalArgumentException("Visit date/time and reply are required.");
        }
        return requestRepository.save(request);
    }

    // Method to update an existing field visit request with date, time, and reply
    @Override
    public Request updateRequest(Long id, Request updatedRequest) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            // Validate visitDateTime and reply
            if (updatedRequest.getVisitDateTime() == null || updatedRequest.getReply() == null || updatedRequest.getReply().isEmpty()) {
                throw new IllegalArgumentException("Visit date/time and reply are required.");
            }
            request.setVisitDateTime(updatedRequest.getVisitDateTime());
            request.setReply(updatedRequest.getReply());
            return requestRepository.save(request);
        } else {
            throw new RuntimeException("Request not found with id: " + id);
        }
    }
}
