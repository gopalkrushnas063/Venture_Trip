package com.venture.venturetrip.model.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
   
    private Integer ticketID;

    private String name;
    private String address;
    private String mobileNo;
    private String status;
    private String From;
    private String To;
    private Integer ticketCost;
    private LocalDate DateofJourney;
   

}
