package com.Backend.HarvestMaster.SupportPersonnel.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SupportPersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supportPersonnel_ID;

    private String name;
    private String contactNum;

    public SupportPersonnel() {
    }

    public int getSupportPersonnel_ID() {
        return supportPersonnel_ID;
    }

    public void setSupportPersonnel_ID(int supportPersonnel_ID) {
        this.supportPersonnel_ID = supportPersonnel_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }
}
