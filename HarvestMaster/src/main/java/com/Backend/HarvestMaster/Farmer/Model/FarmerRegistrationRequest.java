package com.Backend.HarvestMaster.Farmer.Model;

import com.Backend.HarvestMaster.User.Model.User;

public class FarmerRegistrationRequest {
    private User user;
    private Farmer farmer;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
}
