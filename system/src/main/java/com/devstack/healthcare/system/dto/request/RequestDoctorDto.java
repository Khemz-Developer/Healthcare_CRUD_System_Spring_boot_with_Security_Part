package com.devstack.healthcare.system.dto.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDoctorDto {

    private String name;

    private String address;

    private String contact;

    private double salary;
}
