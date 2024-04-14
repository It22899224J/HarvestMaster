package com.Backend.HarvestMaster.PaddyHealth.Service;

import com.Backend.HarvestMaster.PaddyHealth.Model.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    // Method to retrieve all field visit requests
    List<Request> getAllFieldVisitRequests();

    // Method to retrieve a field visit request by its id
    Optional<Request> getFieldVisitRequestById(Long id);

    // Method to add a new field visit request with date, time, and reply
    Request addRequest(Request request);

    // Method to update an existing field visit request with date, time, and reply
    Request updateRequest(Long id, Request request);
}
