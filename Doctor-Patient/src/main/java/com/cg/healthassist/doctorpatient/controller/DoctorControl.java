package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.exception.DoctorNotFoundException;
import com.cg.healthassist.doctorpatient.serviceImpl.DoctorServiceImpl;

/** This class is for Doctor Controller 
 * 
 * @author Swathi
 * 
 * */

@RestController
@RequestMapping("/Doctor")
public class DoctorControl {
	
		@Autowired
		private DoctorServiceImpl docService;
		
		@PostMapping("/addDoctor")
		public Doctor addDoctor(@RequestBody Doctor doctor)
		{
			return docService.addDoctor(doctor);
		}
		
		@GetMapping("/getDoctorById/{DoctorId}")
		public Doctor getDoctorById(@PathVariable Integer DoctorId) throws DoctorNotFoundException
		{
			return docService.findDoctorById(DoctorId);
		}
		
		@GetMapping("/getAllDoctors")
		public List<Doctor> getAllDoctors(){
			return(List<Doctor>) docService.getAllDoctors();
		}
		
}
