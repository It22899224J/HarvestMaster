package com.Backend.HarvestMaster.SupportRequest.SupportRequestService;

import com.Backend.HarvestMaster.SupportRequest.Model.LegalOpinion;
import com.Backend.HarvestMaster.SupportRequest.Model.SupportRequest;
import com.Backend.HarvestMaster.SupportRequest.Repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportRequestServiceImpl implements SupportRequestService{

  @Autowired
    private SupportRepository supportRepository;


    @Override
    public SupportRequest addRequest(SupportRequest supportRequest) {
        return supportRepository.save(supportRequest);
    }

  @Override
  public List<SupportRequest> getAllRequest() {
    return supportRepository.findAll();
  }

  @Override
  public SupportRequest getRequest(Integer id) {
    return supportRepository.findById(id).get();
  }

  @Override
  public LegalOpinion addLegalOpinion(LegalOpinion legalOpinion) {
    return legalOpinion;
  }

  @Override
  public boolean deleteRequest(Integer id) {

      supportRepository.deleteById(id);
    return true;
  }
}
