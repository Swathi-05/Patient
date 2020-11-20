package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.healthassist.doctorpatient.entity.MedicalStore;

/** This is an interface of medicalStoreRepository 
 * 
 * @author Swathi
 * 
 * **/ 

public interface MedicalStoreRepository extends JpaRepository<MedicalStore, Integer> {

}
