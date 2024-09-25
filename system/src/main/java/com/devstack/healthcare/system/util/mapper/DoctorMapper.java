package com.devstack.healthcare.system.util.mapper;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    ResponseDoctorDto toResponseDoctorDto(Doctor doctor);
    // convert entity to dto

    Doctor toDoctor(RequestDoctorDto requestDoctorDto);
    // convert dto to entity

    List<ResponseDoctorDto> toResponseDoctorDtoList(List<Doctor> doctors);
}
