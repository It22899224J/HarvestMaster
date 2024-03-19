package com.Backend.HarvestMaster.FinancialManager.Service;

import com.Backend.HarvestMaster.FinancialManager.Model.FinancialManager;
import com.Backend.HarvestMaster.User.Model.User;

public interface FinancialManagerService {

    FinancialManager createFinancialManager(User user, FinancialManager financialManager);

    FinancialManager getFinancialManagerByEmail(String email);
}
