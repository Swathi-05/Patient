package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.exception.DoctorNotFoundException;
import com.cg.healthassist.doctorpatient.repository.DoctorRepository;


/** The DoctorServiceImpl class provides methods to add, find and view all doctor
 *  
 * @author Swathi
 * 
 * **/

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
    private DoctorRepository doctorRepository;

	/** this method is to add doctor details **/
	
	@Override
	public Doctor addDoctor(Doctor doctor) { 
		 return doctorRepository.save(doctor);
	}

	/** this method is to find doctor details by id 
	 * @throws DoctorNotFoundException **/
	
	@Override
	public Doctor findDoctorById(Integer doctorId) throws DoctorNotFoundException  {
		 return doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("doctor not found for this id :: " + doctorId));
	}

	/** this method is to getAll doctor details **/
	
	@Override
	public List<Doctor> getAllDoctors()  {
		 return doctorRepository.findAll();
	}
}
