package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.exception.DoctorNotFoundException;
import com.cg.healthassist.doctorpatient.service.DoctorServiceImpl;

/** This class is for Doctor Controller 
 * 
 * @author Swathi
 * 
 * */

@RestController
@RequestMapping("/doctor")
public class DoctorControl {
	
		@Autowired
		private DoctorServiceImpl docService;

		@PostMapping("/add")
		public Doctor addDoctor(@RequestBody Doctor doctor) throws DoctorNotFoundException
		{
			return docService.addDoctor(doctor);
		}
		
		@GetMapping("/get/{doctorId}") 
		public @ResponseBody  Doctor getDoctorById(@PathVariable(value="doctorId") Integer doctorId) throws DoctorNotFoundException
		{
			return docService.findDoctorById(doctorId);
		}
		
		@GetMapping("/getall") 
		public List<Doctor> getAllDoctors() throws DoctorNotFoundException{
			return docService.getAllDoctors();
		}
		
}
