package com.Backend.HarvestMaster.PaddyHealth.Model;
import jakarta.persistence.*;


@Table(name = "issue")
@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String date;
    private String farmerName;
    private String fieldLocation;
    private byte[] imageData;
    private String observedIssues;

    private String damagedSection;
    private String status; // pending or accepted


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFieldLocation() {
        return fieldLocation;
    }

    public void setFieldLocation(String fieldLocation) {
        this.fieldLocation = fieldLocation;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getObservedIssues() {
        return observedIssues;
    }

    public void setObservedIssues(String observedIssues) {
        this.observedIssues = observedIssues;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDamagedSection() {
        return damagedSection;
    }


    public void setDamagedSection(String damagedSection) {
        this.damagedSection = damagedSection;
    }
}

