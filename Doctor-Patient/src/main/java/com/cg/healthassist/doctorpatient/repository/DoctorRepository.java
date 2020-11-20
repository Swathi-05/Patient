package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthassist.doctorpatient.entity.Doctor;

/** This is an interface of doctorRepository 
 * 
 * @author Swathi
 * 
 * **/ 

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
}
