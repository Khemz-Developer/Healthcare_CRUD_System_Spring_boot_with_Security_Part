package com.devstack.healthcare.system.api;


import com.devstack.healthcare.system.dto.request.RequestDoctorDto;
import com.devstack.healthcare.system.service.DoctorService;
import com.devstack.healthcare.system.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // this annotation is used to create RESTful web services using Spring MVC
@RequestMapping("/api/v1/doctors")  // this annotation is used to map web requests onto specific handler classes and/or handler methods
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    //http://localhost:8000/api/v1/doctors
    @PostMapping
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestDoctorDto requestDoctorDto) {

        doctorService.createDoctor(requestDoctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Doctor created", requestDoctorDto.getName()),
                org.springframework.http.HttpStatus.CREATED
        );
    }


    //http://localhost:8000/api/v1/doctors/S-HC-D-1
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getDoctor(@PathVariable String id) {

        return new ResponseEntity<>(
                new StandardResponse(200, "Doctor fetched", doctorService.getDoctor(Long.parseLong(id))),
                org.springframework.http.HttpStatus.OK
        );
    }


    //http://localhost:8000/api/v1/doctors/list?searchText=doctor&page=1&size=10
    @GetMapping(path = "/list", params = {"searchText", "page", "size"})
    public ResponseEntity<StandardResponse> getAllDoctors(

            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size) {

        return new ResponseEntity<>(
                new StandardResponse(200, "Doctors fetched", doctorService.getAllDoctors(searchText, page, size)),
                org.springframework.http.HttpStatus.OK
        ) ;
    }


    //http://localhost:8000/api/v1/doctors?id=S-HC-D-1
    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateDoctor(
            @RequestParam String id,
            @RequestBody RequestDoctorDto requestDoctorDto) {

        doctorService.updateDoctor(Long.parseLong(id), requestDoctorDto);

        return new ResponseEntity<>(
                new StandardResponse(200, "Doctor updated", requestDoctorDto.getName()),
                org.springframework.http.HttpStatus.OK
        );
    }


    //http://localhost:8000/api/v1/doctors/S-HC-D-1
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteDoctor(@PathVariable String id) {

        doctorService.deleteDoctor(Long.parseLong(id));

        return new ResponseEntity<>(
                new StandardResponse(204, "Doctor deleted", id),
                org.springframework.http.HttpStatus.NO_CONTENT
        );

    }

}

