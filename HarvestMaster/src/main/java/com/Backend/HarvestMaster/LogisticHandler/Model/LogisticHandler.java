package com.Backend.HarvestMaster.LogisticHandler.Model;

import com.Backend.HarvestMaster.User.Model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LogisticHandler extends User {
    @Id
    private Integer id;
}
