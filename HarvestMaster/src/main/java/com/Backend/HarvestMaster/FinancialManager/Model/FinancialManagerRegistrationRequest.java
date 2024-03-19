package com.Backend.HarvestMaster.FinancialManager.Model;


import com.Backend.HarvestMaster.User.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinancialManagerRegistrationRequest {
    private User user;
    private FinancialManager financialManager;
}
