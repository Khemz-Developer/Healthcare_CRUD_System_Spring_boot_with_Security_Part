package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.response.ResponseDoctorDto;
import com.devstack.healthcare.system.dto.response.paginated.PaginatedDoctorResponseDto;
import com.devstack.healthcare.system.entity.Doctor;
import com.devstack.healthcare.system.exceptions.EntryNotFoundException;
import com.devstack.healthcare.system.repo.DoctorRepo;
import com.devstack.healthcare.system.service.DoctorService;
import com.devstack.healthcare.system.util.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo, DoctorMapper doctorMapper) {
        this.doctorRepo = doctorRepo;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public void createDoctor(RequestDoctorDto requestDoctorDto) {

        UUID uuid = UUID.randomUUID();
        long docId = uuid.getMostSignificantBits();
        Doctor doctor = new Doctor(
                 docId,
                requestDoctorDto.getName(),
                requestDoctorDto.getAddress(),
                requestDoctorDto.getContact(),
                requestDoctorDto.getSalary()
        );
        doctorRepo.save(doctor);
    }

//    @Override
//    public ResponseDoctorDto getDoctor(long id) {
//        //give code to get data
//        Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
//        ResponseDoctorDto responseDoctorDto = new ResponseDoctorDto();
//        responseDoctorDto.setId(doctor.getId());
//        responseDoctorDto.setName(doctor.getName());
//        responseDoctorDto.setAddress(doctor.getAddress());
//        responseDoctorDto.setContact(doctor.getContact());
//        responseDoctorDto.setSalary(doctor.getSalary());
//        return responseDoctorDto;
//
//    }
    public ResponseDoctorDto getDoctor(long id) {
        //give code to get data
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if(selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor not found");
        }else {
//            Doctor doctor = selectedDoctor.get();
//            ResponseDoctorDto responseDoctorDto = new ResponseDoctorDto();
//            responseDoctorDto.setId(doctor.getId());
//            responseDoctorDto.setName(doctor.getName());
//            responseDoctorDto.setAddress(doctor.getAddress());
//            responseDoctorDto.setContact(doctor.getContact());
//            responseDoctorDto.setSalary(doctor.getSalary());
//            return responseDoctorDto;

            return doctorMapper.toResponseDoctorDto(selectedDoctor.get());
        }

    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto requestDoctorDto) {

        if(doctorRepo.existsById(id)){
            Doctor doctor = new Doctor(
                    id,
                    requestDoctorDto.getName(),
                    requestDoctorDto.getAddress(),
                    requestDoctorDto.getContact(),
                    requestDoctorDto.getSalary()
            );
            doctorRepo.save(doctor);
        }else{
            throw new EntryNotFoundException("Doctor not found");
        }

    }

    @Override
    public void deleteDoctor(long id) {

        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);

        if(selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor not found");
        }else {
            doctorRepo.deleteById(selectedDoctor.get().getId());
        }

    }

    @Override
    public PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size) {

        searchText = "%" + searchText + "%";
        List<Doctor> doctors =  doctorRepo.searchDoctors(searchText, PageRequest.of(page,size));
        long doctorCount = doctorRepo.countDoctors(searchText);
        List<ResponseDoctorDto> responseDoctorDtos = doctorMapper.toResponseDoctorDtoList(doctors);



//        doctors.forEach(doctor -> {
//            responseDoctorDtos.add(new ResponseDoctorDto(
//                    doctor.getId(),
//                    doctor.getName(),
//                    doctor.getAddress(),
//                    doctor.getContact(),
//                    doctor.getSalary()
//            ));
//        });
        return new PaginatedDoctorResponseDto(
            doctorCount,
            responseDoctorDtos

        );
    }

    @Override
    public List<ResponseDoctorDto> findDoctorByName(String name) {
        List<Doctor> doctors = doctorRepo.findAllByName(name);
        return null;

    }
}
