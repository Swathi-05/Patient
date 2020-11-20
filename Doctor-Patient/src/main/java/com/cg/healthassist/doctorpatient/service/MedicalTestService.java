package com.cg.healthassist.doctorpatient.service;

import java.util.List;
import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.exception.MedicalTestNotFoundException;

/** This is service interface for medicalTest
 * 
 * @author Swathi
 * 
 * **/

public interface MedicalTestService {

	/** method is to add medicalTest **/
	MedicalTest addMedicalTest(MedicalTest medicalTest) throws MedicalTestNotFoundException;
	
	/** method is to find medicalTest by Id **/
	MedicalTest findMedicalTestById(Integer medicalTestId) throws MedicalTestNotFoundException;
	
	/** method is to getAll medicalTest **/
    List<MedicalTest> getAllMedicalTests() throws MedicalTestNotFoundException;
}
