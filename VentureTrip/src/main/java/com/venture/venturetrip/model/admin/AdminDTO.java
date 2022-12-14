package com.venture.venturetrip.model.admin;


import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {
    private String mobile;
    private String password;
}
