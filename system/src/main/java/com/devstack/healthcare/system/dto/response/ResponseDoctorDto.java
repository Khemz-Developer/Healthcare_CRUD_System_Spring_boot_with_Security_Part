package com.devstack.healthcare.system.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data
public class ResponseDoctorDto {

    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
