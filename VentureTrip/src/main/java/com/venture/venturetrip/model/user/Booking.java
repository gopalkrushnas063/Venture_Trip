package com.venture.venturetrip.model.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @JsonIgnore
    private Integer bookingID;
    @Size(min = 1, message = "User name cannot be null")
    private String name;
    @NotNull
    private String address;
    @Pattern(regexp="(^$|[0-9]{10})",message = "Phone number should be 10 digits")
    private String mobileNo;


    private LocalDate bookingDate;
    private Integer packageID;

    @Min(value = 1,message = "Price should not be negative")
    private Integer amount;
    private LocalDate DateOfJourney;
    
  

}
