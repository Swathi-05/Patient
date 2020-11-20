package com.cg.healthassist.doctorpatient.service;

import java.util.List;
import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.exception.DoctorNotFoundException;

/** This is service interface for doctor
 * 
 * @author Swathi
 * 
 * **/

public interface DoctorService {

	/** method is to add doctor **/
	Doctor addDoctor(Doctor doctor) throws DoctorNotFoundException;
	
	/** method is to find doctor by Id **/
	Doctor findDoctorById(Integer doctorId) throws DoctorNotFoundException;
	
	/** method is to gatAll doctors **/
    List<Doctor> getAllDoctors() throws DoctorNotFoundException;
    
}
