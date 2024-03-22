package com.Backend.HarvestMaster.LogisticHandler.Service;

import com.Backend.HarvestMaster.LogisticHandler.Model.LogisticHandler;
import com.Backend.HarvestMaster.LogisticHandler.Repository.LogisticHandlerRepository;
import com.Backend.HarvestMaster.User.Model.User;
import com.Backend.HarvestMaster.User.Repository.UserRepository;

public interface LogisticHandlerService {
    LogisticHandler createLogisticHandler(User user, LogisticHandler logisticHandler);

    LogisticHandler getLogisticHandlerByEmail(String email);
}
