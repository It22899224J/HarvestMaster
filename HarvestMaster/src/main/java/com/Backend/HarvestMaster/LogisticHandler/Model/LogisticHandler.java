package com.Backend.HarvestMaster.LogisticHandler.Model;

import com.Backend.HarvestMaster.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Logistic_Handler")
public class LogisticHandler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String phone;

    @OneToOne
    @JoinColumn(name = "u_id")
    private User user;
}
