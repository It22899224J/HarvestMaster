package com.Backend.HarvestMaster.Farmer.Model;

import com.Backend.HarvestMaster.LogisticHandler.Model.Buyer;
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
@Table(name = "farmers")
public class Farmer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agriCode;

    protected String address;
    protected String nic;
    protected String gender;
    protected String phone;

    @OneToOne
    @JoinColumn(name = "u_id")
    private User user;


}
