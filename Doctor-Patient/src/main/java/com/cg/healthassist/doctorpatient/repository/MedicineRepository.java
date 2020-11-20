package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.healthassist.doctorpatient.entity.Medicine;

/** This is an interface of medicineRepository 
 * 
 * @author Swathi
 * 
 * **/ 

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{


}
