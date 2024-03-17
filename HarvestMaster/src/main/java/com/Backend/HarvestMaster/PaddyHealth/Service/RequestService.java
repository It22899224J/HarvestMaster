package com.Backend.HarvestMaster.PaddyHealth.Service;
import com.Backend.HarvestMaster.PaddyHealth.Model.Request;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request createRequest(Request request);
    Request acceptRequest(Long id);
    ResponseEntity<?> scheduleVisit(Long id, String scheduledTime);
    List<Request> getRequestsByStatus(String status);
    Optional<Request> getRequestById(Long id);
    void updateRequest(Request request);
}
