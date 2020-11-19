package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.exception.MedicalTestNotFoundException;
import com.cg.healthassist.doctorpatient.serviceImpl.MedicalTestServiceImpl;

/** This class is for MedicalTest Controller 
 * 
 * @author Swathi
 * 
 * */

@RestController
@RequestMapping("/MedicalTest")

public class MedicalTestControl {
	
	@Autowired
	 MedicalTestServiceImpl testService;
	
	@PostMapping("/addMedicalTest")
	public MedicalTest addMedicalTest(@RequestBody MedicalTest medicalTest)
	{
		return testService.addMedicalTest(medicalTest);
	}
	@GetMapping("/getMedicalTestById/{TestId}")
	public MedicalTest getMedicalTestById(@PathVariable Integer TestId) throws MedicalTestNotFoundException 
	{
		return testService.findMedicalTestById(TestId);
	}
	@GetMapping("/getAllMedicalTests")
	public List<MedicalTest> getAllMedicalTests(){
		return(List<MedicalTest>) testService.getAllMedicalTests();
	}
}
