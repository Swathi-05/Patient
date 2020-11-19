package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.doctorpatient.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
}
