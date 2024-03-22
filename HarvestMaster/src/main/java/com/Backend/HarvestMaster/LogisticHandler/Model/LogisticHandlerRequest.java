package com.Backend.HarvestMaster.LogisticHandler.Model;


import com.Backend.HarvestMaster.User.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogisticHandlerRequest {
    private User user;
    private LogisticHandler logisticHandler;
}
