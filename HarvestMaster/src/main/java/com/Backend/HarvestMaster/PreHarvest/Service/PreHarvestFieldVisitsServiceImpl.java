package com.Backend.HarvestMaster.PreHarvest.Service;

import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestFieldVisits;
import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestFieldVisitProjection;
import com.Backend.HarvestMaster.PreHarvest.Repository.PreHarvestFieldVisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreHarvestFieldVisitsServiceImpl implements PreHarvestFieldVisitsService {
    @Autowired
    private PreHarvestFieldVisitsRepository preHarvestFieldVisitsRepository;

    @Override
    public PreHarvestFieldVisits addFieldVisit(PreHarvestFieldVisits preHarvestFieldVisits){
        return  preHarvestFieldVisitsRepository.save(preHarvestFieldVisits);
    }

    @Override
    public List<PreHarvestFieldVisitProjection> getAllFieldVisits(Integer fieldId) {
        return preHarvestFieldVisitsRepository.findAllProjected(fieldId);
    }

    @Override
    public PreHarvestFieldVisits getFieldVisitById(Integer fieldObservationId) {
        return preHarvestFieldVisitsRepository.findById(fieldObservationId).get();
    }

    @Override
    public PreHarvestFieldVisits updateFieldVisits(Integer observationId, PreHarvestFieldVisits preHarvestFieldVisits) {
        preHarvestFieldVisits.setFieldObservationId(observationId);
        return preHarvestFieldVisitsRepository.save(preHarvestFieldVisits);
    }

    @Override
    public boolean deleteFieldVisit(Integer observationId) {
        preHarvestFieldVisitsRepository.deleteById(observationId);
        return true;
    }
}
