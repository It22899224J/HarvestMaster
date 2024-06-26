package com.Backend.HarvestMaster.Inventory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String Product_type;
    private String Product_Name;
    private String Description;
    private int quantity;
    private  int Packege_Type;
    private  float Price;
    private Blob image;


}
