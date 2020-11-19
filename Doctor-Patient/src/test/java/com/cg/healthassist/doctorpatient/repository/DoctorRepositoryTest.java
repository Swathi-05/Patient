package com.cg.healthassist.doctorpatient.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.doctorpatient.entity.Doctor;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class DoctorRepositoryTest {

	    @Autowired
	    private DoctorRepository doctorRepository;

	    @Autowired
	    private TestEntityManager testEntityManager;

	    @Test
	    public void testaddDoctor() throws Exception{
	    	 Doctor doctor = getDoctor();
		        Doctor saveInDb = testEntityManager.persist(doctor);
		        Doctor getInDb = doctorRepository.findById(doctor.getDoctorId()).get();
		        assertThat(getInDb).isEqualTo(saveInDb);
		      
		    }

			 private Doctor getDoctor() { 
				Doctor doc=new Doctor(); 
				doc.setDoctorId(2);
			 doc.setDoctorName("Ron");
			 doc.setDoctorSpeciality("dermatologist");
			  doc.setExperience(8);
			  return doc;
			 }
			 
	    

	    @Test
	    void testGetDoctorById() throws Exception{
	        Doctor doctor = new Doctor();
	        doctor.setDoctorId(112);
	        doctor.setDoctorName("Sohal");
	        doctor.setDoctorSpeciality("cardiologist");
	        doctor.setExperience(9);
	        
	        Doctor saveInDb = testEntityManager.persist(doctor);
	        Doctor getInDb = doctorRepository.findById(doctor.getDoctorId()).get();        
	        assertThat(getInDb).isEqualTo(saveInDb);
	    }

	    @Test
	     void testGetAllDoctors() throws Exception{
			 Doctor doctor = new Doctor();
			 	doctor.setDoctorId(325);
		        doctor.setDoctorName("Sumo");
		        doctor.setDoctorSpeciality("Brain");
		        doctor.setExperience(10);
			 
		        Doctor doc=new Doctor();
				doc.setDoctorId(2);
				doc.setDoctorName("Ron");
		        doc.setDoctorSpeciality("dermatologist");
		        doc.setExperience(8);
				
		        testEntityManager.persist(doctor);
		        testEntityManager.persist(doc);

		        List<Doctor> doctorList = (List<Doctor>) doctorRepository.findAll();

		        Assert.assertEquals(2, doctorList.size());
		    }

}
