package com.Backend.HarvestMaster.User.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String address;

    protected String type;
    protected String nic;
    protected String gender;
    protected String email;

    protected String password;
    protected String phone;

    public User() {
    }
}
