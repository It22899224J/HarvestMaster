package com.Backend.HarvestMaster.SupportRequest.SupportRequestService;

import com.Backend.HarvestMaster.SupportRequest.Model.SupportRequest;

import java.util.List;

public interface SupportRequestService {

    public SupportRequest addRequest(SupportRequest supportRequest);
    public List<SupportRequest> getAllRequest() ;


}
