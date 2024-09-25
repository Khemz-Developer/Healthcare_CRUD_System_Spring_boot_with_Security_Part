package com.devstack.healthcare.system.repo;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devstack.healthcare.system.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    public List<Doctor> findAllByName(String name);

    @Query(value = "SELECT * FROM doctor WHERE name LIKE %:searchText% OR address LIKE %:searchText% OR contact LIKE %:searchText%", nativeQuery = true)
    public List<Doctor> searchDoctors(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM doctor WHERE name LIKE %:searchText% OR address LIKE %:searchText% OR contact LIKE %:searchText%", nativeQuery = true)
    public Long countDoctors(String searchText);
}
