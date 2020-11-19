package com.cg.healthassist.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthassist.doctorpatient.entity.MedicalTest;

public interface MedicalTestRepository extends JpaRepository<MedicalTest, Integer>{

}
