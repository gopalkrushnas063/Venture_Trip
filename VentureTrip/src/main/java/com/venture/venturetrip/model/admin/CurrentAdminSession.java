package com.venture.venturetrip.model.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

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
