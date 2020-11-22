package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.exception.MedicalTestNotFoundException;
import com.cg.healthassist.doctorpatient.service.MedicalTestServiceImpl;

/** This class is for MedicalTest Controller 
 * 
 * @author Swathi
 * 
 * */

@RestController
@RequestMapping("/api/medicalTest")
@Validated
public class MedicalTestControl {
	
	@Autowired
	 MedicalTestServiceImpl testService;
	
	@PostMapping("/add")
	public MedicalTest addMedicalTest(@Valid @RequestBody MedicalTest medicalTest)
	{
		return testService.addMedicalTest(medicalTest);
	}
	@GetMapping("/get/{testId}")
	public MedicalTest getMedicalTestById(@Valid @PathVariable Integer testId) throws MedicalTestNotFoundException  
	{
		return testService.findMedicalTestById(testId);
	}
	@GetMapping("/getall")
	public List<MedicalTest> getAllMedicalTests(){
		return testService.getAllMedicalTests();
	}
}
