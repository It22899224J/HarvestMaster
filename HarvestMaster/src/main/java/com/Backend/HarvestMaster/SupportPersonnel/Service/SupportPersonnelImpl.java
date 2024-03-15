package com.Backend.HarvestMaster.SupportPersonnel.Service;

import com.Backend.HarvestMaster.SupportPersonnel.Model.SupportPersonnel;
import com.Backend.HarvestMaster.SupportPersonnel.Repository.SupportPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportPersonnelImpl implements SupportPersonnelService{
    @Autowired
    private SupportPersonnelRepository supportPersonnelRepository;
    @Override
    public SupportPersonnel addSupportPersonnel(SupportPersonnel supportPersonnel) {
        return supportPersonnelRepository.save(supportPersonnel);
    }

    @Override
    public SupportPersonnel getSupportPersonnel(Integer id) {
        return supportPersonnelRepository.findById(id).get();
    }

    @Override
    public List<SupportPersonnel> getAllSupportPersonnel() {
        return supportPersonnelRepository.findAll();
    }

    @Override
    @Async
    public boolean deleteSupportPersonnel(Integer id) {

                supportPersonnelRepository.deleteById(id);
                return true;
    }

    @Override
    public SupportPersonnel updateSupportPersonnel(SupportPersonnel supportPersonnel) {
        return supportPersonnelRepository.save(supportPersonnel);
    }
}
