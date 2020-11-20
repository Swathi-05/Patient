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
import com.cg.healthassist.doctorpatient.exception.DoctorNotFoundException;
import com.cg.healthassist.doctorpatient.repository.DoctorRepository;

/** This class is for Doctor Service Implementation Test
 * 
 * @author Swathi
 * 
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceImplTest {

    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorServiceImpl doctorService;

    /** This method is to test add doctor in the Service implementation class 
     * @throws DoctorNotFoundException **/
    
	@Test
	void testAddDoctor() throws DoctorNotFoundException {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(100);
		doctor.setDoctorName("harry");
		doctor.setDoctorSpeciality("Dermatologist");
		doctor.setDoctorExperience(15);
		
		Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertThat(doctorService.addDoctor(doctor)).isEqualTo(doctor);
	}

	/** This method is to test get doctor by id in the Service implementation class **/

	@Test
	void testFindDoctorById() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(201);
		doctor.setDoctorName("jack");
		doctor.setDoctorSpeciality("neurologist");
		doctor.setDoctorExperience(10);
		
		assertThat(doctor.getDoctorId()).isEqualTo(201);
	}

	/** This method is to test getAll doctor in the Service implementation class 
	 * @throws DoctorNotFoundException **/

	@Test
	void testGetAllDoctors() throws DoctorNotFoundException {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(200);
		doctor.setDoctorName("Peter");
		doctor.setDoctorSpeciality("Plastic Surgeons");
		doctor.setDoctorExperience(8);
		
		Doctor doc=new Doctor();
		doc.setDoctorId(300);
		doc.setDoctorName("vansh");
		doc.setDoctorSpeciality("Brain");
		doc.setDoctorExperience(9);
		
		List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        doctorList.add(doc);

        Mockito.when(doctorRepository.findAll()).thenReturn(doctorList);
        assertThat(doctorService.getAllDoctors()).isEqualTo(doctorList);
	}

}
 