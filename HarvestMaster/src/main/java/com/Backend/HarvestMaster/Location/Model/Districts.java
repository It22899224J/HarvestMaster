package com.Backend.HarvestMaster.Location.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Districts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int provinceId;
    private String nameEn;
    private String nameSi;
    private String nameTa;
}

