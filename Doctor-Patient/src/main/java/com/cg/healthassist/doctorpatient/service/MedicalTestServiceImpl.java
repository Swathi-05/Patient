package com.cg.healthassist.doctorpatient.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.exception.MedicalTestNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicalTestRepository;


/** The MedicalTestServiceImpl class provides methods to add, find and view all medicalTest
 *  
 * @author Swathi
 * 
 * **/

@Service
@Transactional
public class MedicalTestServiceImpl implements MedicalTestService{
	
	@Autowired
	private MedicalTestRepository medicalTestRepository;

	/** this method is to add medicalTest details **/
	
	@Override
	public MedicalTest addMedicalTest(MedicalTest medicalTest) {
		return medicalTestRepository.save(medicalTest);
	}

	/** this method is to find medicalTest details By Id 
	 * @throws MedicalTestNotFoundException **/
	
	@Override
	public MedicalTest findMedicalTestById(Integer medicalTestId) throws MedicalTestNotFoundException {
		return medicalTestRepository.findById(medicalTestId).orElseThrow(() -> new MedicalTestNotFoundException("MedicalTest not found for this id :: " + medicalTestId));
	}

	/** this method is to getAll medicalTest details **/
	
	@Override
	public List<MedicalTest> getAllMedicalTests() {
		 return medicalTestRepository.findAll();
	}
}
	