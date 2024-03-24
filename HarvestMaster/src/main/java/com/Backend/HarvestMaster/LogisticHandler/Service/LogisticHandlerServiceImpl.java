package com.Backend.HarvestMaster.LogisticHandler.Service;

import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandler;
import com.Backend.HarvestMaster.LogisticHandler.Repository.LogisticHandlerRepository;
import com.Backend.HarvestMaster.User.Model.User;
import com.Backend.HarvestMaster.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogisticHandlerServiceImpl implements LogisticHandlerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  LogisticHandlerRepository logisticHandlerRepository;

    public LogisticHandlerServiceImpl(LogisticHandlerRepository logisticHandlerRepository, UserRepository userRepository) {
        this.logisticHandlerRepository = logisticHandlerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LogisticHandler createLogisticHandler(User user, LogisticHandler logisticHandler) {
        User savedUser = userRepository.save(user);
        logisticHandler.setUser(savedUser);
        return logisticHandlerRepository.save(logisticHandler);
    }

    @Override
    public LogisticHandler getLogisticHandlerByEmail(String email) {
        Optional<LogisticHandler> logisticHandlerOptional = logisticHandlerRepository.findByUserEmail(email);
        return logisticHandlerOptional.orElse(null);
    }
}
