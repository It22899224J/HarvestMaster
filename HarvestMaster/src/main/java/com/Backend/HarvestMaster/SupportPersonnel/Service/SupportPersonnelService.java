package com.Backend.HarvestMaster.SupportPersonnel.Service;

import com.Backend.HarvestMaster.SupportPersonnel.Model.SupportPersonnel;

import java.util.List;

public interface SupportPersonnelService {

    public SupportPersonnel addSupportPersonnel(SupportPersonnel supportPersonnel);
    public SupportPersonnel getSupportPersonnel(Integer id);

    public List<SupportPersonnel> getAllSupportPersonnel ();
    public boolean deleteSupportPersonnel(Integer id);

    public SupportPersonnel updateSupportPersonnel(SupportPersonnel supportPersonnel);

}
