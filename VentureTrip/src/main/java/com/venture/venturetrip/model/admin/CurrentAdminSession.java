package com.venture.venturetrip.model.admin;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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


    public CurrentAdminSession(Integer adminId, String key, LocalDateTime now) {
    }
}
