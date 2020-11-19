package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import com.cg.healthassist.doctorpatient.entity.MedicalTest;

public interface MedicalTestService {

	MedicalTest addMedicalTest(MedicalTest medicalTest);
	MedicalTest findMedicalTestById(Integer MedicalTestId);
    List<MedicalTest> getAllMedicalTests();
}
