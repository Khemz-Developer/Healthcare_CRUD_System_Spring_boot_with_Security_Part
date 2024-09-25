package com.devstack.healthcare.system.service;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.dto.response.paginated.PaginatedDoctorResponseDto;

import java.util.List;

public interface DoctorService {

    public void createDoctor(RequestDoctorDto requestDoctorDto);

    public ResponseDoctorDto getDoctor(long id);

    public void updateDoctor(long id, RequestDoctorDto requestDoctorDto);

    public void deleteDoctor(long id);

    public PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size);

    public List<ResponseDoctorDto> findDoctorByName(String name);
}
