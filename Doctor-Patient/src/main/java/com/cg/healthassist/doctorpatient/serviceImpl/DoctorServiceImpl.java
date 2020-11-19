package com.cg.healthassist.doctorpatient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.repository.DoctorRepository;
import com.cg.healthassist.doctorpatient.service.DoctorService;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
    private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		 return doctorRepository.save(doctor);
	}

	@Override
	public Doctor findDoctorById(Integer DoctorId) {
		 return doctorRepository.findById(DoctorId).get();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		 return doctorRepository.findAll();
	}
}
