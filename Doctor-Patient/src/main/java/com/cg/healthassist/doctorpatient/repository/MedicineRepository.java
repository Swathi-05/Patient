package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthassist.doctorpatient.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}
