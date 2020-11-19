package com.cg.healthassist.doctorpatient.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.repository.DoctorRepository;
import com.cg.healthassist.doctorpatient.serviceImpl.DoctorServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceImplTest {


    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorServiceImpl doctorService;

	@Test
	void testAddDoctor() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(100);
		doctor.setDoctorName("harry");
		doctor.setDoctorSpeciality("Dermatologist");
		doctor.setExperience(15);
		
		Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertThat(doctorService.addDoctor(doctor)).isEqualTo(doctor);
	}

	@Test
	void testFindDoctorById() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(201);
		doctor.setDoctorName("jack");
		doctor.setDoctorSpeciality("neurologist");
		doctor.setExperience(10);
		
		assertThat(doctor.getDoctorId()).isEqualTo(201);
	}


	@Test
	void testGetAllDoctors() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(200);
		doctor.setDoctorName("Peter");
		doctor.setDoctorSpeciality("Plastic Surgeons");
		doctor.setExperience(8);
		
		Doctor doc=new Doctor();
		doc.setDoctorId(300);
		doc.setDoctorName("vansh");
		doc.setDoctorSpeciality("Brain");
		doc.setExperience(9);
		
		List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        doctorList.add(doc);

        Mockito.when(doctorRepository.findAll()).thenReturn(doctorList);
        assertThat(doctorService.getAllDoctors()).isEqualTo(doctorList);
	}

}
 