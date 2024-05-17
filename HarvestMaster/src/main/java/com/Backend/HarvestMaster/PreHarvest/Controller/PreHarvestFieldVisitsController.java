package com.Backend.HarvestMaster.PreHarvest.Controller;

import com.Backend.HarvestMaster.PreHarvest.Model.DTO.PreHarvestFieldVisit;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestFieldVisits;
import com.Backend.HarvestMaster.PreHarvest.Model.PreHarvestPlans;
import com.Backend.HarvestMaster.PreHarvest.Model.Projections.PreHarvestFieldVisitProjection;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestFieldVisitsService;
import com.Backend.HarvestMaster.PreHarvest.Service.PreHarvestPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/PreHarvestFieldVisits")
public class PreHarvestFieldVisitsController {
    @Autowired
    private PreHarvestFieldVisitsService preHarvestFieldVisitsService;
    @Autowired
    private PreHarvestPlansService preHarvestPlansService;

    @PostMapping("/add/{fieldId}")
    public ResponseEntity<?> addFieldVisit(@RequestBody PreHarvestFieldVisit preHarvestFieldVisit, @PathVariable Integer fieldId) {
        try {
            if(fieldId==null){
                return new ResponseEntity<>("Failed to add pre-harvest field visit", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            PreHarvestPlans currentPlan = preHarvestPlansService.getPreHarvestPlanDetailsById(fieldId);

            if(currentPlan==null){
                return new ResponseEntity<>("Failed to add pre-harvest field visit", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            PreHarvestFieldVisits preHarvestFieldVisits = new PreHarvestFieldVisits();

            preHarvestFieldVisits.setObservationType(preHarvestFieldVisit.getObservationType());
            preHarvestFieldVisits.setObservationDate(preHarvestFieldVisit.getObservationDate());
            preHarvestFieldVisits.setAffectedArea(preHarvestFieldVisit.getAffectedArea());
            preHarvestFieldVisits.setFieldVisitDate(preHarvestFieldVisit.getFieldVisitDate());
            preHarvestFieldVisits.setFieldVisitTime(preHarvestFieldVisit.getFieldVisitTime());
            preHarvestFieldVisits.setVisited(preHarvestFieldVisit.isVisited());
            preHarvestFieldVisits.setRequestStatus(preHarvestFieldVisit.getRequestStatus());
            preHarvestFieldVisits.setPreHarvestPlans(currentPlan);

            PreHarvestFieldVisits fieldVisit = preHarvestFieldVisitsService.addFieldVisit(preHarvestFieldVisits);
            return new ResponseEntity<>(fieldVisit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add pre-harvest field visit", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll/{fieldId}")
    public  ResponseEntity<?> getAllFieldVisits(@PathVariable Integer fieldId){
        try{
            List<PreHarvestFieldVisitProjection> fieldVisits = preHarvestFieldVisitsService.getAllFieldVisits(fieldId);
            return new ResponseEntity<>(fieldVisits,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve pre-harvest plans1", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{fieldObservationId}")
    public ResponseEntity<?> getPreHarvestFieldVisitById(@PathVariable Integer fieldObservationId){
        try{
            PreHarvestFieldVisits preHarvestFieldVisit = preHarvestFieldVisitsService.getFieldVisitById(fieldObservationId);
            return new ResponseEntity<>(preHarvestFieldVisit,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to retrieve pre-harvest plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{fieldId}/{observationId}")
    public ResponseEntity<?> updateFieldVisit(@PathVariable Integer fieldId,@PathVariable Integer observationId,@RequestBody PreHarvestFieldVisit preHarvestFieldVisit){
        try{
            if(fieldId==null){
                return new ResponseEntity<>("Failed to add pre-harvest field visit2", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            PreHarvestPlans currentPlan = preHarvestPlansService.getPreHarvestPlanDetailsById(fieldId);

            if(currentPlan==null){
                return new ResponseEntity<>("Failed to add pre-harvest field visit3", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            PreHarvestFieldVisits preHarvestFieldVisits = new PreHarvestFieldVisits();

            preHarvestFieldVisits.setObservationType(preHarvestFieldVisit.getObservationType());
            preHarvestFieldVisits.setObservationDate(preHarvestFieldVisit.getObservationDate());
            preHarvestFieldVisits.setAffectedArea(preHarvestFieldVisit.getAffectedArea());
            preHarvestFieldVisits.setFieldVisitDate(preHarvestFieldVisit.getFieldVisitDate());
            preHarvestFieldVisits.setFieldVisitTime(preHarvestFieldVisit.getFieldVisitTime());
            preHarvestFieldVisits.setVisited(preHarvestFieldVisit.isVisited());
            preHarvestFieldVisits.setRequestStatus(preHarvestFieldVisit.getRequestStatus());

            preHarvestFieldVisits.setPreHarvestPlans(currentPlan);

            PreHarvestFieldVisits fieldVisit = preHarvestFieldVisitsService.updateFieldVisits(observationId,preHarvestFieldVisits);
            return new ResponseEntity<>(fieldVisit, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to update plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{observationId}")
    public ResponseEntity<?> deleteFieldVisit(@PathVariable Integer observationId) {
        try {
            boolean deleted = preHarvestFieldVisitsService.deleteFieldVisit(observationId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Plan not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete plan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
