package com.Backend.HarvestMaster.FinancialManager.Service;

import com.Backend.HarvestMaster.Farmer.Model.Farmer;
import com.Backend.HarvestMaster.FinancialManager.Model.FinancialManager;
import com.Backend.HarvestMaster.FinancialManager.Repositiory.FinancialManagerRepositiory;
import com.Backend.HarvestMaster.User.Model.User;
import com.Backend.HarvestMaster.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinancialManagerServiceImpl implements FinancialManagerService {

    @Autowired
    private FinancialManagerRepositiory financialManagerRepositiory;

    @Autowired
    private UserRepository userRepository;

    public FinancialManagerServiceImpl(FinancialManagerRepositiory financialManagerRepositiory, UserRepository userRepository) {
        this.financialManagerRepositiory= financialManagerRepositiory;
        this.userRepository = userRepository;
    }
    @Override
    public FinancialManager createFinancialManager(User user, FinancialManager financialManager) {
        User savedUser = userRepository.save(user); // Save user first to get generated ID
        financialManager.setUser(savedUser); // Set the user for the farmer
        return financialManagerRepositiory.save(financialManager);
    }

    @Override
    public FinancialManager getFinancialManagerByEmail(String email) {
        Optional<FinancialManager> financialManagerOptional = financialManagerRepositiory.findByUserEmail(email);
        return financialManagerOptional.orElse(null);
    }
}
