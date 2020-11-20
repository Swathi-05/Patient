package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.healthassist.doctorpatient.entity.MedicalTest;

/** This is an interface of medicalTestRepository 
 * 
 * @author Swathi
 * 
 * **/ 

public interface MedicalTestRepository extends JpaRepository<MedicalTest, Integer>{

}
