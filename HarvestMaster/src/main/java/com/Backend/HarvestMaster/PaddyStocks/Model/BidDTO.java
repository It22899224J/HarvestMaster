package com.Backend.HarvestMaster.PaddyStocks.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



public interface BidDTO {


   int getBidid();
   LocalDate getCreationDate();
   float  getPrice();


}
