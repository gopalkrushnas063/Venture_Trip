package com.venture.venturetrip.model.admin;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CurrentAdminSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique =true)
    private Integer adminId;

    private String uuid;

    private LocalDateTime localDateTime;


    public CurrentAdminSession(Integer adminId, String uuid, LocalDateTime localDateTime) {
        super();
        this.adminId = adminId;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }



}
