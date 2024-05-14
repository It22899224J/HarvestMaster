package com.Backend.HarvestMaster.Location.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int districtId;
    private String nameEn;
    private String nameSi;
    private String nameTa;
    private String subNameEn;
    private String subNameSi;
    private String subNameTa;
    private String postcode;
    private Double latitude;
    private Double longitude;
}

