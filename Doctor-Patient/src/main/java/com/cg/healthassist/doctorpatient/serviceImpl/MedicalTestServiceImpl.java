package com.cg.healthassist.doctorpatient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.repository.MedicalTestRepository;
import com.cg.healthassist.doctorpatient.service.MedicalTestService;

@Service
@Transactional
public class MedicalTestServiceImpl implements MedicalTestService{
	@Autowired
	private MedicalTestRepository medicalTestRepository;

	@Override
	public MedicalTest addMedicalTest(MedicalTest medicalTest) {
		return medicalTestRepository.save(medicalTest);
	}

	@Override
	public MedicalTest findMedicalTestById(Integer MedicalTestId) {
		return medicalTestRepository.findById(MedicalTestId).get();
	}

	@Override
	public List<MedicalTest> getAllMedicalTests() {
		 return medicalTestRepository.findAll();
	}
}
	