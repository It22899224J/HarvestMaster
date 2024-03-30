package com.Backend.HarvestMaster.Admin.Model;

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
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String phone;

    @OneToOne
    @JoinColumn(name = "u_id")
    private User user;
}
