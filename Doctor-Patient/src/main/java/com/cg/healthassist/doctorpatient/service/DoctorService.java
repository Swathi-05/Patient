package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import com.cg.healthassist.doctorpatient.entity.Doctor;

public interface DoctorService {

	Doctor addDoctor(Doctor doctor);
	Doctor findDoctorById(Integer DoctorId);
    List<Doctor> getAllDoctors();
    
}
