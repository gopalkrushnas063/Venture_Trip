package com.venture.venturetrip.model.admin;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer packageID;
    private String packageName;
  
    private String description;
  
  
    private Integer packageCost;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Travels travels;
    
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Route route;
    
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;
    
}
